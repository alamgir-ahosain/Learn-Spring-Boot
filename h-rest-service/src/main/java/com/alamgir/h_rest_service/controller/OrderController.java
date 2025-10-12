package com.alamgir.h_rest_service.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alamgir.h_rest_service.request.order.Order;

@RestController
public class OrderController {

    @RequestMapping(path = "/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String showOrder(@RequestBody Order order) {

        System.out.println(order);

        return "successfully..";
    }
}
