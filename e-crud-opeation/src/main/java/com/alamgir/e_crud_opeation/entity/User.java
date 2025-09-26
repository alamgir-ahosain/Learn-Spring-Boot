package com.alamgir.e_crud_opeation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @Column(name = "uid")
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    
    public User(){}
    public User(int id, String name, String email) {  this.id = id;  this.name = name;  this.email = email;  }
    public int getId() { return id;  }
    public void setId(int id) {  this.id = id;  }
    public String getName() {return name;}
    public void setName(String name) { this.name = name;}
    public String getEmail() {   return email; }
    public void setEmail(String email) {    this.email = email; }
    


}
