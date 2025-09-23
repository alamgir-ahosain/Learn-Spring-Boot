package com.alamgir.b_dependency_injection.via_interface;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    public Car() {
        System.out.println("car Bean is created..");
    }

    @Override
    public String vehicleType() {
        return "type : car";
    }

}
