package com.alamgir.d_jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alamgir.d_jdbc.crud.Crud;

@SpringBootApplication
public class DJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DJdbcApplication.class, args);
		Crud c = context.getBean(Crud.class);
		
		// c.insertStudent(10,"Abc","abc@gmiail.com");
		// c.updateStudent(10, "update abc", "abc@gmail.com");
		// c.deleteStudent(10);
		c.readAll();

	}

}
