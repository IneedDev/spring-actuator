package com.example.actuator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private int age;
    private BigDecimal salary;
    private String designation;
    private Address address;
    private long[] phoneNumbers;
    private Map<String, String> personalInformation;

    public int getId() {
        return id;
    }
}
