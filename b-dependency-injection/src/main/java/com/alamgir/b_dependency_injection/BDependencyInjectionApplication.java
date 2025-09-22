package com.alamgir.b_dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.alamgir.b_dependency_injection.field_injection.Student;
import com.alamgir.b_dependency_injection.inject_primitives.DbConfig;
import com.alamgir.b_dependency_injection.inject_primitives.DbConfig2;
import com.alamgir.b_dependency_injection.via_interface.Garage;

@PropertySource(value = "external_application.properties")
@SpringBootApplication
public class BDependencyInjectionApplication {

	static void fieldInjection(ConfigurableApplicationContext context) {
		Student student = (Student) context.getBean("student2");
		System.out.println(student.getId());
		System.out.println(student.getAddress());
		System.out.println(student.getAddress().getEmail());
	}

	static void viaInterface(ConfigurableApplicationContext context) {
		Garage garage = (Garage) context.getBean("garage");
		System.out.println(garage);
		System.out.println(garage.getVehicle());
		System.out.println(garage.getVehicle().vehicleType());

	}

	static void injectPrimitives(ConfigurableApplicationContext context) {
		DbConfig dbConfig = (DbConfig) context.getBean("dbConfig");
		System.out.println(dbConfig.getPort());
		System.out.println(dbConfig.getUrl());
		System.out.println(dbConfig.getUserName());
		System.out.println(dbConfig.getPassword());
		System.out.println(dbConfig.getDbProfile());
		System.out.println(dbConfig.getDatabase());
		System.out.println(dbConfig.getDbProfile().getPassword());

	}

		static void exterbalInjectPrimitives(ConfigurableApplicationContext context) {
		DbConfig2 dbConfig2 = (DbConfig2) context.getBean("dbConfig2");
		System.out.println(dbConfig2.getPort());
		System.out.println(dbConfig2.getUrl());
		System.out.println(dbConfig2.getUserName());
		System.out.println(dbConfig2.getDbProfile());
		System.out.println(dbConfig2.getDatabase());
		System.out.println(dbConfig2.getDbProfile().getPassword());

	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BDependencyInjectionApplication.class, args);

		// fieldInjection(context)
		// viaInterface(context);
		//injectPrimitives(context);
		exterbalInjectPrimitives(context);

	}

}
