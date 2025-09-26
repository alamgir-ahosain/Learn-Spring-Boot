package com.alamgir.e_crud_opeation.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class Create {
    @Autowired
    UserRepository userRepository;

    public void insertUser() {
        User u = new User();
        u.setId(5);
        u.setName("e");
        u.setEmail("e@gmail.com");
        userRepository.save(u);
    }

    public void insertMultipleUser() {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "a", "a@gmail.com"));
        users.add(new User(2, "b", "b@gmail.com"));
        users.add(new User(3, "c", "c@gmail.com"));

        userRepository.saveAll(users);
    }

}
