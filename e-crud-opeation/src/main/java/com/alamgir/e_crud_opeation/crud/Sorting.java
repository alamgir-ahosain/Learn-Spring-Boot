package com.alamgir.e_crud_opeation.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class Sorting {
    @Autowired
    UserRepository userRepository;

    public void sortUser() {
        List<User> users = userRepository.findAll(Sort.by("name"));
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

        });

    }

    public void sortUserDesc() {
        List<User> users = userRepository.findAll(Sort.by(Direction.DESC, "name"));
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

        });
    }

    public void sortUserbyIdAndName() {
        List<User> users = userRepository.findAll(Sort.by(Direction.DESC, "id", "name"));
        users.forEach(u -> {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

        });

    }

}