package com.alamgir.e_crud_opeation.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class NativeSql {
    @Autowired
    UserRepository userRepository;

    public void loadUser() {

        List<User> users = userRepository.getUser();
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        });

    }

    public void loadUserByNameAndEmail(String name, String email) {

        List<User> users = userRepository.getUserByNameAndEmail(name, email);
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        });
        // users.forEach(System.out::println);

    }

    public void loadUserByNameAndEmailNamed(String name, String email) {

        List<User> users = userRepository.getUserByNameAndEmailNamed(name, email);
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        });

    }

}
