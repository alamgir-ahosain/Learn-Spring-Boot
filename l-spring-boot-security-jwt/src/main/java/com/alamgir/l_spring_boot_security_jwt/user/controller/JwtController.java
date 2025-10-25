package com.alamgir.l_spring_boot_security_jwt.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alamgir.l_spring_boot_security_jwt.jwt.JwtTokenHelper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class JwtController {

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @GetMapping("/jwt/create/{email}")
    public String getMethodName(@PathVariable String email) {
        return jwtTokenHelper.createToken(email);
    }

    @GetMapping("/jwt/validate")
    public boolean validateToken() {
        return jwtTokenHelper.isValidToken(
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGFtZ2lyQGdtYWlsLmNvbSIsImlhdCI6MTc2MTIwMzA4NCwiZXhwIjoxNzYxMjAzMzg0fQ.cxFEEXGG8JSMV7H-8f_mpiQ3Hs9bG8RBZKlWn8c0vlA",
                "alamgir@gmail.com");
    }

}
