package com.example.actuator.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonNodeDemo {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private JsonNode rootNode;
    private ObjectMapper objectMapper;

    public JsonNodeDemo() throws IOException {
      objectMapper = new ObjectMapper();
      rootNode = objectMapper.readTree(new File("employee.json"));
    }

    public JsonNode readJsonWithJsonNodeToGetSpecifiValue() throws JsonProcessingException {
        String prettyPrintJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        logger.info(prettyPrintJson);
        return rootNode;
    }
}


