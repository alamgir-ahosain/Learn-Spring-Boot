package com.alamgir.g_jsp_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alamgir.g_jsp_spring_boot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registration_form";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(path = "/account/login", method = RequestMethod.POST)
    public ModelAndView handleUserRegistration(HttpServletRequest request) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean success = userService.RegisterUser(name, email, password);

        ModelAndView mav = new ModelAndView();
        if (success) {
            mav.setViewName("login");
        } else {

            mav.setViewName("registration_form");
        }
        return mav;
    }

    @RequestMapping(path = "account/profile", method = RequestMethod.POST)
    public ModelAndView handleUserLogin(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean success = userService.LoginUser(email, password);

        ModelAndView mav = new ModelAndView();
        if (success) {
            mav.setViewName("profile");
        } else {

            mav.setViewName("login");
        }
        return mav;
    }

}
