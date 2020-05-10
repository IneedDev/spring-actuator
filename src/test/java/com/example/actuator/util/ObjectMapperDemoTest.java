package com.example.actuator.util;

import org.junit.Test;
import java.io.IOException;


public class ObjectMapperDemoTest {

    @Test
    public void readJsonWithObjectMapper() throws IOException {
        ObjectMapperDemo objectMapperDemo = new ObjectMapperDemo();
        objectMapperDemo.readJsonWithObjectMapper();
    }

    @Test
    public void readJsonWithObjectMapperToMapTest() throws IOException {
        ObjectMapperDemo objectMapperDemo = new ObjectMapperDemo();
        objectMapperDemo.readJsonWithObjectMapperToMap();
    }

}