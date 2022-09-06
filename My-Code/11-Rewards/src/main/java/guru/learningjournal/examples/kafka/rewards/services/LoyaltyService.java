package guru.learningjournal.examples.kafka.rewards.services;

import guru.learningjournal.examples.kafka.rewards.bindings.PosListenerBinding;
import guru.learningjournal.kafka.avroposgen.model.Notification;
import guru.learningjournal.kafka.avroposgen.model.PosInvoice;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(PosListenerBinding.class)
public class LoyaltyService {
    @Autowired
    RecordBuilder recordBuilder;

    @StreamListener("invoice-input-channel")
    @SendTo("notification-output-channel")
    public KStream<String, Notification> process(KStream<String, PosInvoice> input){
        KStream<String, Notification> notificationKStream = input
                .filter((key, value) -> value.getCustomerType().trim().equalsIgnoreCase("PRIME")) //Filter PRIME customers
                // In this map() we are changing the Key. We are changing the key to the customer unique card number via the new KeyValue<>().
                // Also, in this map() we are transforming from PosInvoice type to Notification type
                // Finally, since we are changing the key. The framework work on repartitioning with the new key (unique card number)
                .map((key, value) -> new KeyValue<>(value.getCustomerCardNo().toString(), recordBuilder.getNotification(value)))
                // Before doing any aggregation we need to group by.
                .groupByKey() //The groupByKey() is key preserving the key (unique card number)
                // We do the aggregation calculation in reduce() method.
                .reduce((aggValue, newValue) -> {
                    newValue.setTotalLoyaltyPoints(newValue.getEarnedLoyaltyPoints() + aggValue.getTotalLoyaltyPoints());
                    return newValue;
                }).toStream();

        notificationKStream.foreach((k, v) -> log.info(String.format("Notification - Key: %s, Value: %s", k, v)));
        return notificationKStream;
    }
}
