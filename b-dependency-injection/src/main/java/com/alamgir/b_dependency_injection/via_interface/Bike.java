package com.alamgir.b_dependency_injection.via_interface;

public class Bike implements Vehicle {
    public Bike() {
        System.out.println("car Bean is created..");
    }

    @Override
    public String vehicleType() {
        return "type : Bike";
    }

}
