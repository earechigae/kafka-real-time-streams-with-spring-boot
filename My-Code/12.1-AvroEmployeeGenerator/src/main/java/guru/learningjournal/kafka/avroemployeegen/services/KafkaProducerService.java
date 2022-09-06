package guru.learningjournal.kafka.avroemployeegen.services;

import guru.learningjournal.examples.kafka.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaProducerService {
    @Autowired
    KafkaTemplate<String, Employee> kafkaTemplate;

    @Value("${application.configs.topic.name}")
    private String TOPIC_NAME;

    public void sendMessage(Employee employee){
        log.info(String.format("Producing employee id: %s, Name: %s",
                employee.getId(), employee.getName()));
        kafkaTemplate.send(TOPIC_NAME, employee.getId(), employee);
    }
}
