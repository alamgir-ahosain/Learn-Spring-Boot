package com.alamgir.b_dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alamgir.b_dependency_injection.fieldInjection.Student;

@SpringBootApplication
public class BDependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BDependencyInjectionApplication.class, args);

		Student student = (Student) context.getBean("student2");
		System.out.println(student.getId());
		System.out.println(student.getAddress());
		System.out.println(student.getAddress().getEmail());

	}

}
