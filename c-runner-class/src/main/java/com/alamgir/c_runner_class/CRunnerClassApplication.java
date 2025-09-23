package com.alamgir.c_runner_class;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alamgir.c_runner_class.beans.Student;

@SpringBootApplication
public class CRunnerClassApplication {

	public static void main(String[] args) {

		System.out.println(args.length);
		System.out.println(args);

		System.out.println("Before run() method..");
		ConfigurableApplicationContext context = SpringApplication.run(CRunnerClassApplication.class, args);
		System.out.println("After run() method..");

		// operation
		Student student = (Student) context.getBean("student");
		System.out.println(student);

	}

}
