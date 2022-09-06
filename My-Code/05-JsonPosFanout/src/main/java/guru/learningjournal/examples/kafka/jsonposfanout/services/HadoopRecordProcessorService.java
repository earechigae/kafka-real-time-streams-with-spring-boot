package guru.learningjournal.examples.kafka.jsonposfanout.services;

import guru.learningjournal.examples.kafka.jsonposfanout.bindings.PosListenerBinding;
import guru.learningjournal.examples.kafka.jsonposfanout.model.HadoopRecord;
import guru.learningjournal.examples.kafka.jsonposfanout.model.PosInvoice;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(PosListenerBinding.class)
public class HadoopRecordProcessorService {
    @Autowired
    RecordBuilder recordBuilder;

    @StreamListener("hadoop-input-channel")
    @SendTo("hadoop-output-channel")
    public KStream<String, HadoopRecord> process(KStream<String, PosInvoice> input){
        KStream<String, HadoopRecord> hadoopRecordKStream = input
                .mapValues(invoice -> recordBuilder.getMaskedInvoice(invoice))
                .flatMapValues(invoice -> recordBuilder.getHadoopRecords(invoice));

        hadoopRecordKStream.foreach((k, v) -> log.info(String.format("Hadoop Record - Key: %s, Value: %s", k, v)));

        return hadoopRecordKStream;
    }
}
