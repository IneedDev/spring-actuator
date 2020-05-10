package com.example.actuator.util;

import com.example.actuator.dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@Component
public class ObjectMapperDemo {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public Employee readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(new File("employee.json"), Employee.class);
        logger.info(employee.toString());
        return employee;
    }

    public void readJsonWithObjectMapperToMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<?, ?> employeeMap = objectMapper.readValue(new FileInputStream("employee.json"), Map.class);

        for (Map.Entry<?, ?> entry : employeeMap.entrySet()) {
            logger.info("\n................\n" + entry.getKey() + "  =   " + entry.getValue()+ "\n");
        }
    }

}
