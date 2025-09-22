package com.alamgir.b_dependency_injection.inject_primitives;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbConfig2 {

    // non-primitive
    @Autowired
    private DbProfile dbProfile;

    @Value("${external.db.port.number}")
    private int port;

    @Value("${external.db.database}")
    private List<String> database;

    // deafult value
    @Value("${external.db.host:localhost}")
    private String url;

    private String userName;

    @Value("${external.db.username}")
    public void setUserName(String userName) {
        System.out.println("setUserName and inject via Setter method");
        this.userName = userName;
    }

    public DbConfig2() {
        System.out.println("dbConfig Bean is created..");
    }

    public DbProfile getDbProfile() {
        return dbProfile;
    }

    public void setDbProfile(DbProfile dbProfile) {
        this.dbProfile = dbProfile;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<String> getDatabase() {
        return database;
    }

    public void setDatabase(List<String> database) {
        this.database = database;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

}
