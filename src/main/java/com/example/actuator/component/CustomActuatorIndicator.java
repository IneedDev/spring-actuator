package com.example.actuator.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomActuatorIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = 0;
        if (errorCode != 0) {
            return Health.down().withDetail("Error code from custom indicator", errorCode).build();
        }
        return Health.up().status("customer status").build();
    }
}
