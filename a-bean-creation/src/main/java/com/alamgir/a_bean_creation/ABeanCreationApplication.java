package com.alamgir.a_bean_creation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alamgir.a_bean_creation.beans.Address;
import com.alamgir.a_bean_creation.beans.Student;

@SpringBootApplication
public class ABeanCreationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(ABeanCreationApplication.class, args);

		// Access Bean Object from Container
		Student student = (Student) container.getBean("student");
		Student student1 = (Student) container.getBean("student1");
		System.out.println(student);
		System.out.println(student1);

		Address address = (Address) container.getBean("address");
		Address address1 = (Address) container.getBean("address1");
		System.out.println(address);
		System.out.println(address1);

	}

}
