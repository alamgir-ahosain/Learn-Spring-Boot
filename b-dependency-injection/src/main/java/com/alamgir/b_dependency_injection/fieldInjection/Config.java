package com.alamgir.b_dependency_injection.fieldInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    

    @Bean
    public Student student2() {
        System.out.println("student2 Bean is created..");
        Student student = new Student();
        student.setId(1);
        return student;

    }
     
    @Bean
    public Address address2(){
        System.out.println("address2 bean is created");
        Address address=new Address();
        address.setEmail("alamgir.ahosain@gmail.com");
        return address;
    }

}
