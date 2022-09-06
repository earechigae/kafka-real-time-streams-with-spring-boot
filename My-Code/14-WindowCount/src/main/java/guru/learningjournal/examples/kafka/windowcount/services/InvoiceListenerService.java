package guru.learningjournal.examples.kafka.windowcount.services;

import guru.learningjournal.examples.kafka.windowcount.bindings.InvoiceListenerBinding;
import guru.learningjournal.examples.kafka.windowcount.model.SimpleInvoice;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

@Service
@Log4j2
@EnableBinding(InvoiceListenerBinding.class)
public class InvoiceListenerService {

    @StreamListener("invoice-input-channel")
    public void process(KStream<String, SimpleInvoice> input){
        // With the peek() function we send to the log the received messages
        input.peek((k, v) -> log.info("Key = {}, Crated Time = {}",
                k, v.getCreatedTime() /*Instant.ofEpochMilli(v.getCreatedTime()).atOffset(ZoneOffset.UTC)*/))
                .groupByKey() //We group by Key as we send the StoreId as the message Key
                // Whenever we use a time window with the following features, we are defining a "Tumbling" window:
                // 1. Fixed size
                // 2. No overlap
                // 3. No gaps
                // Finally, be aware the framework does not allow you to define the time window start time
                .windowedBy(TimeWindows.ofSizeWithNoGrace(Duration.ofMinutes(5))) //We define the "Tumbling" time window of 5 minutes
                .count() //We count the messages by the 5 minutes window
                .toStream() //We need to convert the KTable to KStream
                .foreach((wKey, value) -> log.info(
                        "Store ID: " + wKey.key() +
                        ", Windows ID: " + wKey.window().hashCode() +
                        ", Window start: " + Instant.ofEpochMilli(wKey.window().start()).atOffset(ZoneOffset.UTC) +
                        ", Windows end: " + Instant.ofEpochMilli(wKey.window().end()).atOffset(ZoneOffset.UTC) +
                        ", Count: " + value));
    }
}
