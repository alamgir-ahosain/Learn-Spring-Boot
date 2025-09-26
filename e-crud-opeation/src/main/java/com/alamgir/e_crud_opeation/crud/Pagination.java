package com.alamgir.e_crud_opeation.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.alamgir.e_crud_opeation.entity.User;
import com.alamgir.e_crud_opeation.repository.UserRepository;

@Component
public class Pagination {

    @Autowired
    UserRepository userRepository;

    public void getFirstPageUsers() {
        Page<User> pageObj = userRepository.findAll(Pageable.ofSize(3));
        if (!pageObj.isEmpty()) {
            List<User> users = pageObj.getContent();
            users.forEach(u -> {
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

            });

        }

    }

    // Sort+Pagination
    public void getUsersByPage(int pageNumber, int pageSize) {

        // Page<User> pageObj = userRepository.findAll(PageRequest.of(pageNumber, pageSize));
        // Page<User> pageObj = userRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("id")));
        // Page<User> pageObj = userRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC, "name")));
        
        Page<User> pageObj= userRepository.findAll(PageRequest.of(pageNumber, pageSize, Direction.DESC, "id"));
        if (!pageObj.isEmpty()) {
            List<User> users = pageObj.getContent();
            users.forEach(u -> {
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());

            });

        }

    }

}
