package com.alamgir.c_runner_class.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class SecondRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SecondRunner");
        System.out.println("Option name:" + args.getOptionNames());
        System.out.println("Non-option args: " + args.getNonOptionArgs());
    }

    public void runThis2() {
        System.out.println("Not part of the Spring Boot Runner method");
    }

}
