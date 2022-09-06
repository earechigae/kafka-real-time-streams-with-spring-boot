package guru.learningjournal.examples.kafka.simpleunittest.services;

import guru.learningjournal.examples.kafka.simpleunittest.bindings.ListenerBinding;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(ListenerBinding.class)
public class ListenerService {

    @StreamListener("process-in-0")
    @SendTo("process-out-0")
    public KStream<String, String> process(KStream<String, String> input){
        input.foreach((k, v) -> log.info("Received Input: {}", v));
        return input.mapValues(v -> v.toUpperCase());
    }
}
