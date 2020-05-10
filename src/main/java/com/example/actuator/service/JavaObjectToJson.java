package com.example.actuator.service;

import com.example.actuator.dto.Car;
import com.example.actuator.util.ResourceLoaderUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class JavaObjectToJson {

    @Autowired
    ResourceLoaderUtil resourceLoaderUtil;

    public String javaObjectToJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("test", "test2");
        try {
            objectMapper.writeValue(new File("target/car.json"), car);
            return objectMapper.writeValueAsString(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Car jsonToJavaObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        try {
            Car car = objectMapper.readValue(json, Car.class);
            return car;
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

    public Car jsonFileToJavaObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = resourceLoaderUtil.loadFileFromResource();
//            Car car = objectMapper.readValue(new File("src/test/resources/json_car.json"), Car.class);
            Car car = objectMapper.readValue(file, Car.class);

            return car;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Car> getObjectListFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = resourceLoaderUtil.loadFileWithJsonListFromResource();
            List<Car> listCar = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
            return listCar;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Car> getObjectListFromJsonFileWithAdditionalField() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            File file = resourceLoaderUtil.loadFileWithJsonListWithAdditionalFieldsFromResource();
            List<Car> listCar = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
            return listCar;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }}
