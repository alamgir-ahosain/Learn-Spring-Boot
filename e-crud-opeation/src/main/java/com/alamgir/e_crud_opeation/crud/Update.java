package com.alamgir.e_crud_opeation.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class Update {
    @Autowired
    UserRepository userRepository;

    // load and save
    public void updateUserById(int id, String email) {

        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setEmail(email);
            userRepository.save(user);

        } else {
            System.out.println("No record Found!");
        }

    }

}
