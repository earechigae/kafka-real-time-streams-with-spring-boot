package guru.learningjournal.kafka.examples.kakfaproducer.services;

import guru.learningjournal.kafka.examples.kakfaproducer.model.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageController {
    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage message){
        kafkaProducerService.sendMessage(message.getTopic(), message.getKey(), message.getValue());
        return String.format("Success - Message for Key: %s is sent to Kafka Topic: %s",
                message.getKey(), message.getTopic());
    }
}
