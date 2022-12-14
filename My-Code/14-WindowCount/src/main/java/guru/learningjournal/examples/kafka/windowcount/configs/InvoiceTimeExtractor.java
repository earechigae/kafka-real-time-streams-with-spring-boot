package guru.learningjournal.examples.kafka.windowcount.configs;

import guru.learningjournal.examples.kafka.windowcount.model.SimpleInvoice;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class InvoiceTimeExtractor implements TimestampExtractor {
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long prevMessageTime) {
        SimpleInvoice invoice = (SimpleInvoice) consumerRecord.value();
        long eventTime = Instant.parse(invoice.getCreatedTime()).toEpochMilli();
        return ((eventTime > 0)? eventTime : prevMessageTime);
        //return ((invoice.getCreatedTime() > 0)? invoice.getCreatedTime() : prevMessageTime);
    }

    @Bean
    public TimestampExtractor invoiceTimesExtractor(){
        return new InvoiceTimeExtractor();
    }
}
