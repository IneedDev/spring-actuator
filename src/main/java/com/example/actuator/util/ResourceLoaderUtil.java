package com.example.actuator.util;

import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class ResourceLoaderUtil {

    @Autowired
    ResourceLoader resourceLoader;

    public Resource loadJsonFromResource() {
        return resourceLoader.getResource("classpath:json/json_car.json");
    }

    public File loadFileFromResource() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:json/json_car.json");
    }

    public File loadFileWithJsonListFromResource() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:json/json_car_list.json");
    }

    public File loadFileWithJsonListWithAdditionalFieldsFromResource() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:json/json_list_new_fields.json");
    }

    public File loadEmployeeFileFromResource() throws FileNotFoundException {
        System.out.println("test");
        return ResourceUtils.getFile("classpath:json/employee.json");
    }
}
