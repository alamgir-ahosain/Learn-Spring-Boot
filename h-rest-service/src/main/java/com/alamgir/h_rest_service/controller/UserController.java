package com.alamgir.h_rest_service.controller;

import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alamgir.h_rest_service.request.UserList;
import com.alamgir.h_rest_service.request.UserLogin;
import com.alamgir.h_rest_service.request.UserRequest;
import com.alamgir.h_rest_service.responce.UserResponce;
import com.alamgir.h_rest_service.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponce> readAllUser() {
        List<UserResponce> userResponce = userService.readAllUser();
        return userResponce;

    }

    @RequestMapping(path = "/user/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponce readUser(@PathVariable("email") String email) {
        UserResponce userResponce = userService.readUserById(email);
        return userResponce;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody UserRequest userRequest) {

        String responce = userService.CreateUser(userRequest);
        return responce;
    }

    @RequestMapping(path = "/account/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponce loginUser(@RequestBody UserLogin userLogin) {
        System.out.println(userLogin);
        UserResponce userResponce = userService.LoginUser(userLogin);
        return userResponce;

    }

    // ! JSON : list of Object
    @RequestMapping(path = "/userlist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String userList(@RequestBody UserList userList) {
        System.out.println(userList.getName());
        System.out.println(userList.getUserResponces());
        return "all info here";
    }

    @RequestMapping(path = "/user/v2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser2(@RequestBody UserRequest userRequest) {

        String msg = userService.CreateUser(userRequest);

        if (msg.equals("User Created Succesfully..")) {
            // return new ResponseEntity<String>(msg, HttpStatusCode.valueOf(201));
            return ResponseEntity.status(HttpStatus.CREATED).body(msg);

        }
        // return new ResponseEntity<String>(msg, HttpStatusCode.valueOf(200));
        // return ResponseEntity.ok(msg);
        return ResponseEntity.status(HttpStatus.OK).body(userService.CreateUser(userRequest));

    }

    // !add header
    @RequestMapping(path = "/user/v2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponce> readAllUserv2(@RequestHeader("Security-token") String header) {
        System.out.println(header);
        List<UserResponce> userResponce = userService.readAllUser();
        return userResponce;

    }

    @RequestMapping(path = "/user/v3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetUser(
            @RequestHeader(name = "Security-token", required = false, defaultValue = "token") String securityToken,
            HttpServletRequest request) {
        Enumeration<String> str = request.getHeaderNames();
        System.out.println(str);
        System.out.println(request.getHeader("accept"));
        System.out.println(request.getHeader("Security-token"));
        return "Request from: " + securityToken;
    }

    // ! Response Header
    @RequestMapping(path = "/account/login/v2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponce> loginUserv2(@RequestBody UserLogin userLogin) {
        System.out.println(userLogin);
        UserResponce userResponce = userService.LoginUser(userLogin);
        return ResponseEntity.ok().header("Alamgir-Header", "alamgir").body(userResponce);

    }

    @GetMapping("/hello")
    public String hello() {
        return "alamgir hello";
    }

    // !XML format
    @RequestMapping(path = "api/xml", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_XML_VALUE,  MediaType.APPLICATION_JSON_VALUE })
    public String checkXml(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
        return "Succesfully";
    }

    @RequestMapping(path = "api/xml", method = RequestMethod.GET)
    public UserRequest responceXmlFromat() {

        UserRequest data = new UserRequest();
        data.setFirstName("Alamgir");
        data.setLastName("Hosain");
        data.setEmail("alamgir@gmail.com");
        data.setPassword("12345");
        return data;
    }

}
