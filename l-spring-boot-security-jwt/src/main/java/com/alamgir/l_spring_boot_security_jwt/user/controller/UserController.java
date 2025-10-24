package com.alamgir.l_spring_boot_security_jwt.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

import com.alamgir.l_spring_boot_security_jwt.jwt.JwtTokenHelper;
import com.alamgir.l_spring_boot_security_jwt.user.request.UserChangePasswordRequest;
import com.alamgir.l_spring_boot_security_jwt.user.request.UserLoginRequest;
import com.alamgir.l_spring_boot_security_jwt.user.request.UserRegisterRequest;
import com.alamgir.l_spring_boot_security_jwt.user.response.UserLoginResponse;
import com.alamgir.l_spring_boot_security_jwt.user.response.UserRegisterResponse;
import com.alamgir.l_spring_boot_security_jwt.user.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/public")
    public String publicApi() {
        return "Public API here  ";
    }

    @PostMapping("/public/register")
    public ResponseEntity<UserRegisterResponse> postMethodName(@Valid @RequestBody UserRegisterRequest request) {
        String msg = userService.createUserAccount(request);
        return ResponseEntity.ok(new UserRegisterResponse(request.getName(), request.getEmail(), msg));

    }

    @PostMapping("/public/login")
    public ResponseEntity<UserLoginResponse> loginUser(@Valid @RequestBody UserLoginRequest loginRequest) {

        this.doAuthenticate(loginRequest.getEmail(), loginRequest.getPassword());
        String token = this.jwtTokenHelper.createToken(loginRequest.getEmail());
        return ResponseEntity.ok(new UserLoginResponse(loginRequest.getEmail(), token));

    }

    public void doAuthenticate(String username, String password) {
        logger.info("Authentication of User credentials");
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(username, password);
        try {
            authenticationManager.authenticate(credentials);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username and password");
        }

    }

    // !----------------------------------------------------------

    @PostMapping("/user/change/password/{email}")
    public String changePassword(@Valid @RequestBody UserChangePasswordRequest cpr, @PathVariable String email) {
        return userService.changePassword(cpr, email);

    }

    @DeleteMapping("/user/delete/{email}")
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);

    }

}
