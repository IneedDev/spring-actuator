package com.example.actuator.util;

import com.example.actuator.dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonWriteObjectMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    ObjectMapper objectMapper = new ObjectMapper();

    public void witeEmployeeToJsonWithObjectMapper(Employee employee) {
        try {
            String jsonToString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(employee.getId()+"_employee.json"), employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
