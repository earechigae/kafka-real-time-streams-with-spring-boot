package guru.learningjournal.kafka.avroemployeegen;

import guru.learningjournal.kafka.avroemployeegen.services.KafkaProducerService;
import guru.learningjournal.kafka.avroemployeegen.services.datagenerator.EmployeesGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {
	@Autowired
	private KafkaProducerService producerService;
	@Autowired
	private EmployeesGenerator employeesGenerator;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(int i = 0; i < employeesGenerator.getMaxEmployees(); i++){
			producerService.sendMessage(employeesGenerator.getNextEmployee(i));
			Thread.sleep(1000);
		}
	}
}
