package com.alamgir.b_dependency_injection.fieldInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("student1")
public class Student {

    private int id;

    @Qualifier("address2") // inject address2 bean id
    @Autowired
    private Address address;

    public Student() {
        System.out.println("student1 Bean is created..");
    }

    public Student(int id, Address address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
