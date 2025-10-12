package com.alamgir.h_rest_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamgir.h_rest_service.entity.User;
import com.alamgir.h_rest_service.repository.UserRepository;
import com.alamgir.h_rest_service.request.UserList;
import com.alamgir.h_rest_service.request.UserLogin;
import com.alamgir.h_rest_service.request.UserRequest;
import com.alamgir.h_rest_service.responce.UserResponce;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String CreateUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return "Found Duplicate Email..";
        }

        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);
        return "User Created Succesfully..";

    }

    public UserResponce LoginUser(UserLogin userLogin) {

        Optional<User> optional = userRepository.findByEmail(userLogin.getEmail());
        UserResponce userResponce = new UserResponce();

        if (!optional.isPresent()) { // User Not Found

            return null;

        }
        if (optional.get().getPassword().equals(userLogin.getPassword())) {

            userResponce.setFirstName(optional.get().getFirstName());
            userResponce.setLastName(optional.get().getLastName());
            userResponce.setEmail(optional.get().getEmail());
            return userResponce;
        }

        return null; // invalid creditantials
    }

    public List<UserList> UserList() {
        return null;
    }

    public List<UserResponce> readAllUser() {
        List<User> users = userRepository.findAll();
        if (users.size() == 0) {
            return null;
        }

        List<UserResponce> urList = new ArrayList<>();

        users.forEach(u -> {
            UserResponce userResponce = new UserResponce();
            userResponce.setFirstName(u.getFirstName());
            userResponce.setLastName(u.getLastName());
            userResponce.setEmail(u.getEmail());
            urList.add(userResponce);

        });
        return urList;
    }

    public UserResponce readUserById(String email) {
        Optional<User> optional = userRepository.findByEmail(email);
        if (!optional.isPresent()) {
            return null;
        }
        UserResponce userResponce = new UserResponce();
        userResponce.setFirstName(optional.get().getFirstName());
        userResponce.setLastName(optional.get().getLastName());
        userResponce.setEmail(optional.get().getEmail());
        return userResponce;

    }
}
