package com.alamgir.k_exception_handling.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandling {

    // Method for : MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException ex,
        HttpServletRequest request) {

        List<FieldError> errors = ex.getFieldErrors();
        List<String> response = errors.stream().map(e -> e.getField() + ":::::" + e.getDefaultMessage()).toList();
        return ResponseEntity.badRequest().body(response);
    }

    // Method for : NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException ex){
        return ResponseEntity.internalServerError().body("Try again later");
    }

    // Method for : if  not specify the spicific exception method
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.internalServerError().body("Try again later");
    }

}
