package com.alamgir.g_jsp_spring_boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamgir.g_jsp_spring_boot.entity.User;
import com.alamgir.g_jsp_spring_boot.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean RegisterUser(String name, String email, String password) {
        System.out.println("Name: " + name + " Email :" + email + " Password: " + password);

        if (userRepository.existsByEmail(email)) {
            return false;
        }

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        userRepository.save(u);
        return true;

    }

    public boolean LoginUser(String email, String password) {

        Optional<User> optional = userRepository.findByEmail(email);
        if (optional.isPresent() && optional.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
