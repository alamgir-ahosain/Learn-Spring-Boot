package com.alamgir.e_crud_opeation.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class Delete {

    @Autowired
    UserRepository userRepository;

    public void deleteUserById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            System.out.println("Successfully Deleted ..");
        } else {
            System.out.println("No record Found..");
        }

    }

    public void deleteUserByName(String name) {
        int cnt = userRepository.deleteByName(name);
        if (cnt > 0) {
            System.out.printf("%d record(s) deleted\n", cnt);
        } else {
            System.out.println("No record found..");
        }
    }
}
