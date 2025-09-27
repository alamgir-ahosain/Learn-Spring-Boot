package com.alamgir.f_entity_relationship_mapping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.f_entity_relationship_mapping.entity.Profile;
import com.alamgir.f_entity_relationship_mapping.entity.User1;
import com.alamgir.f_entity_relationship_mapping.repository.UserProfileRepository;

@Component
public class OneToOne {

    @Autowired
    UserProfileRepository userProfileRepository;


    public void createUser() {
        Profile profile = new Profile();
        profile.setEmail("b@gmail.com");
        profile.setPhone("0172");

        User1 user1 = new User1();
        user1.setName("b");
        user1.setGender("Male");
        user1.setProfile(profile);

        userProfileRepository.save(user1); // insert both User & Profile due to CascadeType.ALL
    }


    public void readUserById(int uid) {
        Optional<User1> optional = userProfileRepository.findById(uid);
        if (optional.isPresent()) {
            User1 users = optional.get();
            System.out.println("User info :" + users.getName() + " " + users.getGender());
            System.out.println("profile info :" + users.getProfile().getEmail() + " " + users.getProfile().getPhone());

        } else {
            System.out.println("User ID not found..");
        }

    }


    public void updateUser() {
        Optional<User1> optional = userProfileRepository.findById(100);
        if (optional.isPresent()) {
            User1 u1 = optional.get();
            u1.setName("Alamgir");

            Profile p1 = u1.getProfile();
            p1.setEmail("alamgir@gmail.com");

            userProfileRepository.save(u1); // update both User & Profile due to CascadeType.ALL

        } else {
            System.out.println("User ID not found..");
        }

    }


    public void deleteUserById(int uid) {
        if (userProfileRepository.existsById(uid)) {
            userProfileRepository.deleteById(uid); // delete both User & Profile due to CascadeType.ALL

        } else {
            System.out.println("User ID not found..");
        }
    }

}
