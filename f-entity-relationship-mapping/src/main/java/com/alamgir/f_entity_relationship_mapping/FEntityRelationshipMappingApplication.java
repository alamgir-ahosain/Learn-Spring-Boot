package com.alamgir.f_entity_relationship_mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.alamgir.f_entity_relationship_mapping.service.ManyToMany;
import com.alamgir.f_entity_relationship_mapping.service.OneToMany;
import com.alamgir.f_entity_relationship_mapping.service.OneToOne;

@SpringBootApplication
public class FEntityRelationshipMappingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FEntityRelationshipMappingApplication.class,args);

		OneToOne oneToOne = context.getBean(OneToOne.class);
		oneToOne.createUser();
		oneToOne.readUserById(100);
		oneToOne.updateUser();
		oneToOne.deleteUserById(101);

		OneToMany oneToMany = context.getBean(OneToMany.class);
		oneToMany.createUser();
		oneToMany.addOrdersToUser(100);
		oneToMany.readUserById(100);
		oneToMany.updateUser();
		oneToMany.deleteUserById(100);

		ManyToMany manyToMany = context.getBean(ManyToMany.class);
		manyToMany.createUserAndRoles();
		manyToMany.readUserAndRulesById(151);
		manyToMany.updateUser();
		manyToMany.deleteUserById(100);

	}

}
