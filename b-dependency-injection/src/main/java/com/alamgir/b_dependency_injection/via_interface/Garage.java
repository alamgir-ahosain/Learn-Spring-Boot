package com.alamgir.b_dependency_injection.via_interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Garage {

    @Qualifier("car2")
    @Autowired
    private Vehicle vehicle;

    public Garage() {
        System.out.println("Garage is created...");
    }

    public Garage(Vehicle vehicle) {
        System.out.println("vehicle is injected via constructor");
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        System.out.println("vehicle injectd via setter method");
        this.vehicle = vehicle;
    }

}
