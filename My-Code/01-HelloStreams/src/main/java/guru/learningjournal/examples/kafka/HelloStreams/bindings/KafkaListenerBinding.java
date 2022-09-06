package guru.learningjournal.examples.kafka.HelloStreams.bindings;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

//This interface purpose is to define input/output bindings
public interface KafkaListenerBinding {
    @Input("input-channel-1")
    KStream<String, String> inputStream();
}
