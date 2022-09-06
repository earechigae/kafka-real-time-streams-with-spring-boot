package guru.learningjournal.examples.kafka.advertclicks.services;

import guru.learningjournal.examples.kafka.advertclicks.bindings.ClicksListenerBinding;
import guru.learningjournal.examples.kafka.advertclicks.models.AdClick;
import guru.learningjournal.examples.kafka.advertclicks.models.AdInventories;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(ClicksListenerBinding.class)
public class ClickListenerService {

    @StreamListener
    public void process(@Input("inventories-channel") GlobalKTable<String, AdInventories> inventory,
                        @Input("clicks-channel") KStream<String, AdClick> clicks){

        clicks.foreach((k, v) -> log.info("Click key: {}, Value: {}", k, v));

        // The purpose of the join is to enrich the click event with the Click Inventory information
        clicks.join(inventory, // Joining clicks event with the GlobalKTable inventory
                (clickKey, cluckValue) -> clickKey, // A GlobalKTable takes a Key-Value mapper lambda to define the join Key
                                                    // Notice it could take a different key (a foreign key)
                                                    // For this requirement we do not need a foreign, for this reason the same key is returned
                (clickValue, inventoryValue) -> inventoryValue) // This is Value joiner lambda.
                                                                // The Value joiner lambda is triggered only if both records keys match
                                                                // Notice the outcome is a KStream
                .groupBy((joinedKey, joinedValue) -> joinedValue.getNewsType(), // We group by the NewsType.
                                                                                // The NewsType is not a Key, for this reason we use groupBy()
                        Grouped.with(Serdes.String(), new JsonSerde<>(AdInventories.class))) // A Serdes is necessary to be defined here
                .count()
                .toStream()
                .foreach((k, v) -> log.info("Click Key: {}, Value: {}", k, v));
    }
}
