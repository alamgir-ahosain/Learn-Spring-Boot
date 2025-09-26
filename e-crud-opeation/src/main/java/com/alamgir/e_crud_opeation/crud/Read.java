package com.alamgir.e_crud_opeation.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class Read {

    @Autowired
    private UserRepository userRepository;

    public void readUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User u = userOptional.get();
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        } else {
            System.out.println("User with ID " + id + " not found.");
        }
    }

    public void readUserByName(String name) {
        List<User> users = userRepository.findByName(name);
        if (users.size() != 0) {
            users.forEach(u -> {
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

            });
        } else {
            System.out.println("No record Found!");
        }

    }

    public void readByNameAndEmail(String name, String email) {
        List<User> users = userRepository.findByNameAndEmail(name, email);
        if (users.size() != 0) {
            users.forEach(u -> {
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

            });
        } else {
            System.out.println("No record Found!");
        }

    }

    public void readyNameOrEmail(String name, String email) {
        List<User> users = userRepository.findByNameOrEmail(name, email);
        if (users.size() != 0) {
            users.forEach(u -> {
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

            });
        } else {
            System.out.println("No record Found!");
        }

    }

    public void readAllUser() {
        List<User> users = userRepository.findAll();
        if (users.size() != 0) {
            users.forEach(u -> {
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

            });
        } else {
            System.out.println("No record Found!");
        }

    }

}
