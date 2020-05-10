package com.example.actuator.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonNodeDemoTest {

    @Test
    public void readJsonWithJsonNodeToGetSpecifiValue() throws IOException {
        JsonNodeDemo jsonNodeDemo = new JsonNodeDemo();
        JsonNode aField = jsonNodeDemo.readJsonWithJsonNodeToGetSpecifiValue().get("name");
        String value = aField.asText();
        System.out.println(value);
    }
}