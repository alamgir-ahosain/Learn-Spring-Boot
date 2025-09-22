package com.alamgir.b_dependency_injection.inject_primitives;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbConfig {

    // non-primitive
    @Autowired
    private DbProfile dbProfile;

    // field injection
    // primitive
    // @Value("8080")
    @Value("${db.port.number}")
    private int port;

    //multiple
    @Value("${db.database}")
    private List<String> database;

    // deafult value
    @Value("${db.host:localhost}")
    private String url;

    private String userName;

    @Value("${db.username}")
    public void setUserName(String userName) {
        System.out.println("setUserName and inject via Setter method");
        this.userName = userName;
    }

    private String password;

    public DbConfig(@Value("${db.password}") String password) {
        super();
        this.password = password;
        System.out.println("setPassword and inject via Constructor method");
    }

    // public DbConfig() {
    // System.out.println("dbConfig Bean is created..");
    // }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DbProfile getDbProfile() {
        return dbProfile;
    }

    public void setDbProfile(DbProfile dbProfile) {
        this.dbProfile = dbProfile;
    }

    public List<String> getDatabase() {
        return database;
    }

    public void setDb(List<String> database) {
        this.database = database;
    }

}
