package com.alamgir.k_exception_handling.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id = "myendpoint")
@Component
public class CustomActuator {

    @Bean
    @ReadOperation
    public String customActuatorMethod() {
        return "This is Custom Actuator Endpoint";
    }
}
