package com.alamgir.b_dependency_injection.via_interface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigInteface {
    @Bean
    public Car car2() {
        System.out.println("car2 bean is created..");
        return new Car();
    }

    @Bean
    public Bike bike2() {
        System.out.println("bike2 bean is created..");
        return new Bike();
    }
}
