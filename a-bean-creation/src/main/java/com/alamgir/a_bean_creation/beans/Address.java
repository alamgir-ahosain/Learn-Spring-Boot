package com.alamgir.a_bean_creation.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {

    public Address() {
        System.out.println("address Bean is Created..");
    }
}
