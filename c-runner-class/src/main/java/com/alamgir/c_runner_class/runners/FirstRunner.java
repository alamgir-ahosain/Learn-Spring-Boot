package com.alamgir.c_runner_class.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class FirstRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("FirstRunner ");
        System.out.println("CommandLineRunner: " + Arrays.toString(args));

    }

    public void runThis() {
        System.out.println("Not part of the Spring Boot Runner method");
    }

}
