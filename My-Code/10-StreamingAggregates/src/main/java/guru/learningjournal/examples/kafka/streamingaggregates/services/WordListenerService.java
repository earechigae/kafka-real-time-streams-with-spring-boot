package guru.learningjournal.examples.kafka.streamingaggregates.services;

import guru.learningjournal.examples.kafka.streamingaggregates.bindings.WordListenerBinding;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log4j2
@EnableBinding(WordListenerBinding.class)
public class WordListenerService {

    @StreamListener("words-input-channel")
    public void process(KStream<String, String> input){
        //In this example we are reading a line of text in the input variable
        KStream<String, String> wordStream = input
                //With this, we create a KStream of words
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split(" ")));

        // 1. Think that wordStream will come like this:
        // Key      Value
        // null     hello
        // null     world
        // null     kafka
        // null     streams

        // 2. Then think in a SQL statement to compute aggregates
        // SELECT count(value)
        // FROM wordStream
        // GROUP BY value

        // 3. .groupBy() only works with Keys, for this reason we are assigning the value as a Key with
        // groupBy((key, value) -> value)
        wordStream.groupBy((key, value) -> value)
                .count()  // The count() is the aggregation formula
                .toStream() // We need to conver it the previous KTable aggreation results to a stream
                .peek((k, v) -> log.info("Word: {}, Count {}", k, v)); //The peek method is an alternative for foeareach method
    }
}
