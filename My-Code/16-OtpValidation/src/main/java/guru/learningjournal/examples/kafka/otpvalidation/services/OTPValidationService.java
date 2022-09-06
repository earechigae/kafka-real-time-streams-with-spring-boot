package guru.learningjournal.examples.kafka.otpvalidation.services;

import guru.learningjournal.examples.kafka.otpvalidation.bindings.OTPListenerBinding;
import guru.learningjournal.examples.kafka.otpvalidation.model.PaymentConfirmation;
import guru.learningjournal.examples.kafka.otpvalidation.model.PaymentRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

@Service
@Log4j2
@EnableBinding(OTPListenerBinding.class)
public class OTPValidationService {
    @Autowired
    private RecordBuilder recordBuilder;

    @StreamListener
    public void process(@Input("payment-request-channel") KStream<String, PaymentRequest> request,
                        @Input("payment-confirmation-channel") KStream<String, PaymentConfirmation> confirmation) {

        request.foreach((k, v) -> log.info("Request Key = {}, Created Time {}", k,
                Instant.ofEpochMilli(v.getCreatedTime()).atOffset(ZoneOffset.UTC)));

        confirmation.foreach((k, v) -> log.info("Confirmation Key = {}, Created Time {}", k,
                Instant.ofEpochMilli(v.getCreatedTime()).atOffset(ZoneOffset.UTC)));

        // To do the join:
        // 1. Both topics must have the same number of partitions
        // 2. Both topics must have the TransactionId as the Key
        // 3. Both topics must use the same default partitioner
        request.join(confirmation, // The other stream we want to join
                // Remember the framework will trigger the lambda if the matching record is found
                (req, conf) -> recordBuilder.getTransactionStatus(req, conf), // Value joiner lambda of 2 arguments
                JoinWindows.of(Duration.ofMinutes(5)), // The time window. Remember joining 2 streams always require a time window
                StreamJoined.with(Serdes.String(), // Define the required Serdes explicitly
                        new JsonSerde<>(PaymentRequest.class),
                        new JsonSerde<>(PaymentConfirmation.class)))
                .foreach((k, v) -> log.info("Transaction ID = {}, Status = {}", k, v.getStatus()));
    }
}
