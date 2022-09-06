package guru.learningjournal.examples.kafka.avroposfanout.services;

import guru.learningjournal.examples.kafka.avroposfanout.bindings.PosListenerBinding;
import guru.learningjournal.kafka.avroposgen.model.Notification;
import guru.learningjournal.kafka.avroposgen.model.PosInvoice;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(PosListenerBinding.class)
public class NotificationProcessorService {
    @Autowired
    RecordBuilder recordBuilder;

    @StreamListener("notification-input-channel")
    @SendTo("notification-output-channel")
    public KStream<String, Notification> process(KStream<String, PosInvoice> input){
        KStream<String, Notification> notificationKStream = input
                .filter((key, value) -> value.getCustomerType().toString().trim().equalsIgnoreCase("PRIME"))
                .mapValues(invoice -> recordBuilder.getNotification(invoice));

        notificationKStream.foreach((k, v) -> log.info(String.format("Notification - Key: %s, Value: %s", k, v)));

        return notificationKStream;
    }
}
