package com.alamgir.e_crud_opeation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alamgir.e_crud_opeation.crud.Jpql;

import com.alamgir.e_crud_opeation.crud.Create;
import com.alamgir.e_crud_opeation.crud.Read;
import com.alamgir.e_crud_opeation.crud.Delete;
import com.alamgir.e_crud_opeation.crud.Pagination;
import com.alamgir.e_crud_opeation.crud.Sorting;
import com.alamgir.e_crud_opeation.crud.NativeSql;
import com.alamgir.e_crud_opeation.crud.Update;

@SpringBootApplication
public class ECrudOpeationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ECrudOpeationApplication.class, args);

		Create c = context.getBean(Create.class);
		c.insertUser();
		c.insertMultipleUser();


		Update u = context.getBean(Update.class);
		u.updateUserById(1, "a@gmail.com");


		Read r = context.getBean(Read.class);
		r.readUserById(12);
		r.readUserByName("Alamgir");
		r.readByNameAndEmail("a", "a@gmail.com");
		r.readyNameOrEmail("a", "a@gmail.com");
		r.readAllUser();


		Delete d = context.getBean(Delete.class);
		d.deleteUserById(1);
		d.deleteUserByName("a");


		Sorting s = context.getBean(Sorting.class);
		s.sortUser();
		s.sortUserDesc();
		s.sortUserbyIdAndName();


		Pagination p = context.getBean(Pagination.class);
		p.getFirstPageUsers();
		p.getUsersByPage(1, 02);


		NativeSql nativeSql = context.getBean(NativeSql.class);
		nativeSql.loadUser();
		nativeSql.loadUserByNameAndEmail("a", "a@gmail.com");
		nativeSql.loadUserByNameAndEmailNamed("a", "a@gmail.com");

		
		Jpql jpql = context.getBean(Jpql.class);
		jpql.getUserJpqlMethod();
		jpql.getUserByNameAndEmailJpqlMethod("a", "a@gmail.com");

	}

}
