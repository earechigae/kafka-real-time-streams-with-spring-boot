package guru.learningjournal.kafka.avroemployeegen.services.datagenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.learningjournal.examples.kafka.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Log4j2
public class EmployeesGenerator {
    private final Employee[] employees;

    private EmployeesGenerator() {
        String DATAFILE = "src/main/resources/data/Employees.json";
        ObjectMapper mapper;
        mapper = new ObjectMapper();
        try {
            employees = mapper.readValue(new File(DATAFILE), Employee[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getMaxEmployees(){
        if(employees != null){
            return employees.length;
        }else{
            return 0;
        }
    }

    public Employee getNextEmployee(int i){
        if(employees == null || (i < 0 || i >= employees.length)){
            return null;
        }else{
            return employees[i];
        }
    }
}
