package guru.learningjournal.examples.kafka.sessionwindow.services;

import guru.learningjournal.examples.kafka.sessionwindow.bindings.ClickListenerBinding;
import guru.learningjournal.examples.kafka.sessionwindow.models.UserClick;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.SessionWindows;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

@Service
@Log4j2
@EnableBinding(ClickListenerBinding.class)
public class ClickListenerService {

    @StreamListener("click-input-channel")
    public void process(KStream<String, UserClick> input) {
        // With the peek() function we send to the log the received messages
        input.peek((k, v) -> log.info("Key = " + k + ", Created Time = "
                        + Instant.ofEpochMilli(v.getCreatedTime()).atOffset(ZoneOffset.UTC)))
                .groupByKey() //We group by Key as we send the UserId as the message Key
                // Be aware the session windows are variable in length and the size of the window is dependent of the user activity
                // We define the "Session" time window of 5 minutes of (idle time) inactivity space between windows of activity
                .windowedBy(SessionWindows.ofInactivityGapWithNoGrace(Duration.ofMinutes(5)))
                .count() //We count the messages by the 5 minutes window
                .toStream() //We need to convert the KTable to KStream
                .foreach((wKey, value) -> log.info(
                        "User ID: " + wKey.key() +
                        ", Windows ID: " + wKey.window().hashCode() +
                        ", Window start: " + Instant.ofEpochMilli(wKey.window().start()).atOffset(ZoneOffset.UTC) +
                        ", Windows end: " + Instant.ofEpochMilli(wKey.window().end()).atOffset(ZoneOffset.UTC) +
                        ", Count: " + value));

    }
}
