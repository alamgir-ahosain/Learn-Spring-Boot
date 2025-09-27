package com.alamgir.f_entity_relationship_mapping.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alamgir.f_entity_relationship_mapping.entity.Orders;
import com.alamgir.f_entity_relationship_mapping.entity.User2;
import com.alamgir.f_entity_relationship_mapping.repository.UserOrderRepository;

@Component
public class OneToMany {

    @Autowired
    UserOrderRepository userOrderRepository;

    public void createUser() {

        Orders newOrder = new Orders();
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setName("Banana");

        User2 user2 = new User2();
        user2.setName("JK");
        user2.setGender("Male");
        user2.getOrders().add(newOrder); // user2.setOrder(List.of(order));

        userOrderRepository.save(user2); // insert both User & Order due to CascadeType.ALL
    }

    public void addOrdersToUser(int uid) {
        Optional<User2> optional = userOrderRepository.findById(uid);
        if (optional.isPresent()) {

            Orders newOrder = new Orders();
            newOrder.setName("Mango");
            newOrder.setOrderDate(LocalDateTime.now());

            User2 user2 = optional.get();
            user2.getOrders().add(newOrder); // add newOrder
            userOrderRepository.save(user2);

        } else {
            System.out.println("User ID not found..");
        }

    }

    public void readUserById(int uid) {
        Optional<User2> optional = userOrderRepository.findById(uid);
        if (optional.isPresent()) {
            User2 users = optional.get();
            System.out.println("User info: " + users.getName() + " " + users.getGender());

            List<Orders> orders = users.getOrders();
            orders.forEach(order -> {
                System.out.println("Order info: " + order.getName() + " " + order.getOrderDate());
            });

        } else {
            System.out.println("User ID not found..");
        }

    }

    public void updateUser() {
        Optional<User2> optional = userOrderRepository.findById(100);
        if (optional.isPresent()) {
            User2 user2 = optional.get();
            user2.setName("Alamgir Hosain");
            userOrderRepository.save(user2); // update both User & Profile due to CascadeType.ALL

        } else {
            System.out.println("User ID not found..");
        }

    }

    public void deleteUserById(int uid) {
    if (userOrderRepository.existsById(uid)) {
    userOrderRepository.deleteById(uid); // delete both User & Profile due toCascadeType.ALL

    } else {
    System.out.println("User ID not found..");
    }
    }

}
