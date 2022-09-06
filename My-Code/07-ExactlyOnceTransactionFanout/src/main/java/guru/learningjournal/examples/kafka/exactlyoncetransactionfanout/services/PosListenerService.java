package guru.learningjournal.examples.kafka.exactlyoncetransactionfanout.services;

import guru.learningjournal.examples.kafka.exactlyoncetransactionfanout.bindings.PosListenerBinding;
import guru.learningjournal.kafka.avroposgen.model.HadoopRecord;
import guru.learningjournal.kafka.avroposgen.model.Notification;
import guru.learningjournal.kafka.avroposgen.model.PosInvoice;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(PosListenerBinding.class)
public class PosListenerService {
    @Autowired
    RecordBuilder recordBuilder;

    @StreamListener("pos-input-channel")
    public void process(KStream<String, PosInvoice> input){
        KStream<String, Notification> notificationKStream = input
                .filter((key, value) -> value.getCustomerType().toString().trim().equalsIgnoreCase("PRIME"))
                .mapValues(invoice -> recordBuilder.getNotification(invoice));

        KStream<String, HadoopRecord> hadoopRecordKStream = input
                .mapValues(invoice -> recordBuilder.getMaskedInvoice(invoice))
                .flatMapValues(invoice -> recordBuilder.getHadoopRecords(invoice));

        notificationKStream.foreach((k, v) -> log.info(String.format("Notification - Key: %s, Value: %s", k, v)));
        hadoopRecordKStream.foreach((k, v) -> log.info(String.format("Hadoop Record - Key: %s, Value: %s", k, v)));

        hadoopRecordKStream.to("avro-hadoop-sink-topic");
        notificationKStream.to("avro-loyalty-topic");
    }
}
