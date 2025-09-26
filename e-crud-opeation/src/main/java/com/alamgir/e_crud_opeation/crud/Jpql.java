package com.alamgir.e_crud_opeation.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class Jpql {

    @Autowired
    UserRepository userRepository;

    public void getUserJpqlMethod() {
        List<User> users = userRepository.getUserJpql();
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        });

    }

    public void getUserByNameAndEmailJpqlMethod(String name, String email) {
        List<User> users = userRepository.getUserByNameAndEmailJpql(name, email);
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        });

    }
}
