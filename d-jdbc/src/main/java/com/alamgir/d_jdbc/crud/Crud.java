package com.alamgir.d_jdbc.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Crud {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertStudent(int id, String name, String email) {
        String query = "INSERT INTO studentTbl VALUES (?, ?, ?)";
        int inserted = jdbcTemplate.update(query, id, name, email);
        if (inserted != 1) {
            System.out.println("Not inserted");
        } else {
            System.out.println("insert succsfully");
        }

    }

    public void updateStudent(int id, String name, String email) {
        String query = "UPDATE studentTbl SET name=?, email=? WHERE id=?";
        int updated = jdbcTemplate.update(query, name, email, id);
        if (updated != 1) {
            System.out.println("Not updated");
        } else {
            System.out.println("update succsfully");
        }

    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM studentTbl WHERE id=?";
        int deleted = jdbcTemplate.update(query, id);
        if (deleted != 1) {
            System.out.println("Not deleted");
        } else {
            System.out.println("delete Successfully");
        }

    }

    public void readAll() {

        String query = "SELECT * FROM studentTbl";
        List<Student> studentLists = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Student>(Student.class));
        // SQL result columns id, name, email : mapped to Student fields id, name email.

        studentLists.forEach(student -> {
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        });

    }

}
