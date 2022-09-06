package guru.learningjournal.kafka.avroposgen.services;

import guru.learningjournal.kafka.avroposgen.model.PosInvoice;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaProducerService {
    @Autowired
    KafkaTemplate<String, PosInvoice> kafkaTemplate;

    @Value("${application.configs.topic.name}")
    private String TOPIC_NAME;

    public void sendMessage(PosInvoice posInvoice){
        log.info(String.format("Producing invoice no.: %s, Customer type: %s",
                posInvoice.getInvoiceNumber(), posInvoice.getCustomerType()));
        kafkaTemplate.send(TOPIC_NAME, posInvoice.getStoreID().toString(), posInvoice);
    }
}
