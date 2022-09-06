package guru.learningjournal.examples.kafka.ktableaggregate.services;


import guru.learningjournal.examples.kafka.ktableaggregate.bindings.EmployeeListenerBinding;
import guru.learningjournal.examples.kafka.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@EnableBinding(EmployeeListenerBinding.class)
public class EmployeeStreamListener {

    @Autowired
    RecordBuilder recordBuilder;

    @StreamListener("employee-input-channel")
    public void process(KStream<String, Employee> input) {
        // We are reading messages in a KStream because the key is coming with NULL values.
        // For this reason, we need to use the map() function to assign the employee id as a key in a new KStream
        input.map((k, v) -> KeyValue.pair(v.getId(), v))
                // With the peek() method we send to the log the messages that are being processed.
                .peek((k, v) -> log.info("Key: {}, Value:{}", k, v))
                .toTable() //Now we need to transform the KStream to a KTable using the toTable() method.
                //We group by department as we want to calculate average salaries by department
                .groupBy((k, v) -> KeyValue.pair(v.getDepartment(), v)) //Notice that with a KTable we need to use KeyValue.pair()
                .aggregate(
                        // Init lambda
                        () -> recordBuilder.init(),
                        // Adder lambda
                        (k, v, aggV) -> recordBuilder.aggregate(v, aggV),
                        // Subtract lambda
                        (k, v, aggV) -> recordBuilder.subtract(v, aggV)
                ).toStream()
                .foreach((k, v) -> log.info("Key = " + k + ", Value = " + v.toString()));
    }
}
