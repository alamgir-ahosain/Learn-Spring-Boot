package com.alamgir.b_dependency_injection.inject_primitives;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbProfile {

    @Value("${db.password}")
    private String password;

    public DbProfile() {
        System.out.println("dbProfile Bean is created ..");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
