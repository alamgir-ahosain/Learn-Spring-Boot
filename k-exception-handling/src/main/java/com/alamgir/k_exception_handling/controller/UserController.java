package com.alamgir.k_exception_handling.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alamgir.k_exception_handling.model.User;
import com.alamgir.k_exception_handling.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

     @Autowired
    UserService userService;

    
    // Method for : MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
         MethodArgumentNotValidException ex,
         HttpServletRequest request) {

        List<FieldError> errors = ex.getFieldErrors();
        List<String> response = errors.stream().map(e -> e.getField() + ": " + e.getDefaultMessage()).toList();
        return ResponseEntity.badRequest().body(response);
    }

   

    @GetMapping("/user")
    public String getAllUser() throws ClassNotFoundException {
        return userService.createUser();
    }

    @PostMapping("/user/create")
    public String getMethodName(@Valid @RequestBody User user) {
        return userService.createUser();
    }

}
