package com.alamgir.k_exception_handling.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public String createUser() {
        System.out.println("Userservice here ...");
        logger.info("UserService  here ...");
        logger.error("UserService  here ..");
        logger.debug("UserService  here ..");

        return "User Created succesfully...";
    }

}
