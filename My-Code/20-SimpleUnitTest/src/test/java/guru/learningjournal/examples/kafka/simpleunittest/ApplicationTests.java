package guru.learningjournal.examples.kafka.simpleunittest;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test; //Make sure to import his class. The IDE brings Junit 5 which does not work.
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.kafka.test.utils.KafkaTestUtils.*;

@Log4j2
@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE, // We tell Spring-Boot to avoid starting web server
		properties = {"server.port=0"}
)
public class ApplicationTests {

	@ClassRule  // This help us to create an embedded kafka cluster
	public static EmbeddedKafkaRule embeddedKafkaRule = new EmbeddedKafkaRule(
			/* Number of brokers */ 1,
			/* Broker must follow controlled shutdown*/ true,
			/* Number of partitions*/ 1,
			/* Topics */ "input-topic", "output-topic" );
	private static EmbeddedKafkaBroker embeddedKafkaBroker = embeddedKafkaRule.getEmbeddedKafka();

	@Autowired // This helps to start the embedded kafka cluster
	StreamsBuilderFactoryBean streamsBuilderFactoryBean;

	private static Consumer<String, String> consumer;

	@BeforeClass
	public static void setup(){
		// 1. Consumer configurations
		Map<String, Object> consumerProps = consumerProps("group", "false", embeddedKafkaBroker);
		consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // With this, the consumer starts reading from the beginning

		// 2. ConsumerFactory and Consumer instance
		DefaultKafkaConsumerFactory<String, String> cf = new DefaultKafkaConsumerFactory<>(consumerProps);
		consumer = cf.createConsumer();

		//3. Configuring consumption topic
		embeddedKafkaBroker.consumeFromAnEmbeddedTopic(consumer, "output-topic");
	}

	@AfterClass
	public static void tearDown(){
		consumer.close();
	}

	@Test
	public void SimpleProcessorApplicationTest(){
		Set<String> actualResultSet = new HashSet<>();
		Set<String> expectedResultSet = new HashSet<>();
		expectedResultSet.add("HELLO1");
		expectedResultSet.add("HELLO2");

		Map<String, Object> senderProps = producerProps(embeddedKafkaBroker);
		DefaultKafkaProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);
		try{
			KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf, true);
			template.setDefaultTopic("input-topic");

			template.sendDefault("hello1");
			template.sendDefault("hello2");

			int receivedAll = 0;
			while (receivedAll < 2){
				ConsumerRecords<String, String> cr = getRecords(consumer);
				receivedAll = receivedAll + cr.count();
				cr.iterator().forEachRemaining(r -> actualResultSet.add(r.value()));
			}

			assertThat(actualResultSet.equals(expectedResultSet)).isTrue();
		}finally {
			pf.destroy();
		}
	}
}
