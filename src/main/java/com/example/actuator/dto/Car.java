package com.example.actuator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String color;
    private String type;



//    public Car(String color, String type) {
//        this.color = color;
//        this.type = type;
//    }
}
