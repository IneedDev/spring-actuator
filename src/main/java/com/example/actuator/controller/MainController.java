package com.example.actuator.controller;

import com.example.actuator.dto.Car;
import com.example.actuator.model.Model;
import com.example.actuator.service.JavaObjectToJson;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/test/api")
@ManagedResource(objectName = "PaulsMBean:category=MBeans,name=testBean")
public class MainController {
    Counter paul_bean;
    private final AtomicLong counter = new AtomicLong();
    private final String template="Hello, %s ";

    @Autowired
    private JavaObjectToJson javaObjectToJson;

    public MainController(MeterRegistry registry) {
        paul_bean = registry.counter("paul_bean");
    }

    @GetMapping("/greeting")
    @ManagedOperation
    public String greeting() throws InterruptedException{
        paul_bean.increment();
        return "hello ...";
    }

    @GetMapping("/get-response")
    @ResponseBody
    public Model getResponseBody(@RequestParam(name = "name", required=false, defaultValue="stranger") String name) {
        return new Model(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/java-to-json")
    public String getJavaObjectToJson(String json) {
        return javaObjectToJson.javaObjectToJsonFile();
    }

    @GetMapping("/json-to-java")
    public Car getObjectFromJson(String json) {
        return javaObjectToJson.jsonToJavaObject();
    }

    @GetMapping("/json-file-to-java")
    public Car getObjectFromJsonFile(String json) {
        return javaObjectToJson.jsonFileToJavaObject();
    }

    @GetMapping("/json-list-to-java")
    public List<Car> getObjectListFromJson(String json) {
        return javaObjectToJson.getObjectListFromJsonFile();
    }

    @GetMapping("/json-missing-field-to-java")
    public List<Car> getObjectListFomJsonWithMissingField(String json) {
        return javaObjectToJson.getObjectListFromJsonFileWithAdditionalField();
    }
}
