package com.alamgir.l_spring_boot_security_jwt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alamgir.l_spring_boot_security_jwt.user.entity.User;
import com.alamgir.l_spring_boot_security_jwt.user.repository.UserRepository;
import com.alamgir.l_spring_boot_security_jwt.user.request.UserChangePasswordRequest;
import com.alamgir.l_spring_boot_security_jwt.user.request.UserLoginRequest;
import com.alamgir.l_spring_boot_security_jwt.user.request.UserRegisterRequest;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public String createUserAccount(UserRegisterRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.getEmail())) {return "Email already Exist..Try again later";}

        User u = new User();
        u.setName(userRequest.getName());
        u.setEmail(userRequest.getEmail());
        u.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        User savedUser = userRepository.save(u);

        if (savedUser != null)   {return "Register Successfully";}
        else  {return "Failed to create User ";}
    }



    public String loginUser(UserLoginRequest loginRequest) {
        User u = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (u != null) { return "Login Success"; }{ return "Invalid Credentials";}
    }

    public String changePassword(UserChangePasswordRequest cpr, String email) {

        // !Step 1: find the user by email
        User u = userRepository.findByEmail(email);
        if (u == null){   return "User not Found";}

        // !Step 2: verify old password
        boolean checkPassword = bCryptPasswordEncoder.matches(cpr.getPassword(),u.getPassword());
        if (!checkPassword){ return "Wrong password";}


        // !Step 3: encode and save new password

        u.setPassword(bCryptPasswordEncoder.encode(cpr.getNewPassword()));
        User savedUser = userRepository.save(u);
        if (savedUser != null) {{ return " Password Update Successfully..";}
        }
        return "Error : Password not updated..";
    }

    @Transactional
    public String deleteUser(String email) {
        Integer cnt = userRepository.deleteByEmail(email);
        if (cnt != null && cnt > 0){ return "User deleted successfully.";}
        return "No user found with the given email.";
    }

}
