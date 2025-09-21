package com.alamgir.a_bean_creation.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {
    public Student() {
        System.out.println("student Bean is Created..");
    }
}
