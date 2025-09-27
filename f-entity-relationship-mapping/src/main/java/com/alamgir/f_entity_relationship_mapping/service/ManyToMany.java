package com.alamgir.f_entity_relationship_mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.f_entity_relationship_mapping.entity.Roles;
import com.alamgir.f_entity_relationship_mapping.entity.User3;
import com.alamgir.f_entity_relationship_mapping.repository.many_to_many.RolesRepository;
import com.alamgir.f_entity_relationship_mapping.repository.many_to_many.UserRepository;

@Component
public class ManyToMany {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    public void createUserAndRoles() {

        Roles role1 = new Roles();  role1.setName("OSS Lead");  role1.setDescription("OSS Lead position");  rolesRepository.save(role1);
        Roles role2 = new Roles();  role2.setName("SE");  role2.setDescription("SE position");  rolesRepository.save(role2);
        User3 user3 = new User3(); user3.setName("JK"); user3.setGender("Male"); user3.getRoles().add(role1);user3.getRoles().add(role2);
        userRepository.save(user3);
    }


    public void readUserAndRulesById(int uid){
        Optional<User3> optional=userRepository.findById(uid);
        if (optional.isPresent()) {
            User3 user3=optional.get();
            System.out.println("User info: "+user3.getName()+" "+user3.getGender());
            List<Roles> roles=user3.getRoles();
            roles.forEach(role->{
                System.out.println("Role info : "+role.getName()+" "+role.getDescription());
            });
        }
        else{
            System.out.println("User ID not found..");
        }
    }



    public void deleteUserById(int uid){
        if (userRepository.existsById(uid)) {
            Optional<User3> optional=userRepository.findById(uid);
            User3 user3=optional.get();
            List<Roles> roles=user3.getRoles();
            roles.forEach(role->{
                rolesRepository.deleteById(role.getRid());
            });
            
            userRepository.deleteById(uid);

        }
        System.out.println("User ID not found..");
    }

    

     public void updateUser() {
        Optional<User3> optional = userRepository.findById(100);
        if (optional.isPresent()) {
            User3 user3 = optional.get();
            user3.setName("Alamgir Hosain");
            userRepository.save(user3); 

        } else {
            System.out.println("User ID not found..");
        }

    }

}
