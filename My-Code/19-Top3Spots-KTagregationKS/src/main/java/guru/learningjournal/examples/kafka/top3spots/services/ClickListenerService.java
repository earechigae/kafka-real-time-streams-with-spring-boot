package guru.learningjournal.examples.kafka.top3spots.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import guru.learningjournal.examples.kafka.top3spots.bindings.ClicksListenerBinding;
import guru.learningjournal.examples.kafka.top3spots.models.AdClick;
import guru.learningjournal.examples.kafka.top3spots.models.AdInventories;
import guru.learningjournal.examples.kafka.top3spots.models.ClicksByNewsType;
import guru.learningjournal.examples.kafka.top3spots.models.Top3NewsTypes;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
@Log4j2
@EnableBinding(ClicksListenerBinding.class)
public class ClickListenerService {

    @StreamListener
    public void process(@Input("inventories-channel") GlobalKTable<String, AdInventories> inventory,
                        @Input("clicks-channel") KStream<String, AdClick> clicks){

        clicks.foreach((k, v) -> log.info("Click key: {}, Value: {}", k, v));

        // The purpose of the join is to enrich the click event with the Click Inventory information
        KTable<String, Long> clicksByNewsTypeKTable = clicks.join(inventory, // Joining clicks event with the GlobalKTable inventory
                (clickKey, cluckValue) -> clickKey, // A GlobalKTable takes a Key-Value mapper lambda to define the join Key
                                                    // Notice it could take a different key (a foreign key)
                                                    // For this requirement we do not need a foreign, for this reason the same key is returned
                (clickValue, inventoryValue) -> inventoryValue) // This is Value joiner lambda.
                                                                // The Value joiner lambda is triggered only if both records keys match
                                                                // Notice the outcome is a KStream
                .groupBy((joinedKey, joinedValue) -> joinedValue.getNewsType(), // We group by the NewsType.
                                                                                // The NewsType is not a Key, for this reason we use groupBy()
                        Grouped.with(Serdes.String(), new JsonSerde<>(AdInventories.class))) // A Serdes is necessary to be defined here
                .count();

        // Now we want to get the top 3 News Type with most of the clicks
        clicksByNewsTypeKTable.groupBy( // We need to group by a different key
                (k, v) -> { // We define a new fake key to bring all the records from different partitions
                    ClicksByNewsType value = new ClicksByNewsType();
                    value.setNewsType(k);
                    value.setClicks(v);
                    return KeyValue.pair("top3NewsTypes", value); //The name of the new fake is top3NewsTypes
                },
                Grouped.with(Serdes.String(), new JsonSerde<>(ClicksByNewsType.class)) //The serdes for the grouping
        ).aggregate( // Remeber the aggregation is in real time
                //Initializer
                () -> new Top3NewsTypes(),
                // Adder
                (k, v, aggV) -> {
                    aggV.add(v);
                    return aggV;
                },
                // Subtractor
                (k, v, aggV) -> {
                    aggV.remove(v);
                    return aggV;
                },
                // Materialization (Serdes) details
                Materialized.<String, Top3NewsTypes, KeyValueStore<Bytes, byte[]>>as("top3-clicks")
                        .withKeySerde(Serdes.String())
                        .withValueSerde(new JsonSerde<>(Top3NewsTypes.class))
        ).toStream().foreach(
                (k, v) -> {
                    try{
                        log.info("Key: {}, Value {}", k, v.getTop3Sorted());
                    }catch(JsonProcessingException exception){
                        exception.printStackTrace();
                    }
                }
        );
    }
}
