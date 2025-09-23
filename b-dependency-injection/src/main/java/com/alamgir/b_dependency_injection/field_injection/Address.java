package com.alamgir.b_dependency_injection.field_injection;

import org.springframework.stereotype.Component;

@Component("address1")
public class Address {
    private String email;

    public Address() {
        System.out.println("address1 Bean is Created..");
    }

    public Address(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
