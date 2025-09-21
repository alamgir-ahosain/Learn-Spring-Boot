package com.alamgir.a_bean_creation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alamgir.a_bean_creation.beans.Address;
import com.alamgir.a_bean_creation.beans.Student;

@Configuration
public class SpringBeanConfiguration {

    @Bean
    public Address address1() {
        System.out.println("address1 bean is created ..");
        return new Address();
    }

    @Bean
    public Student student1() {
        System.out.println("student1 bean is created..");
        return new Student();
    }

}
