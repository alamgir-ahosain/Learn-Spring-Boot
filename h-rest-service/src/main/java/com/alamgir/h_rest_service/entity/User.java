package com.alamgir.h_rest_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false ,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public int getId() {  return id;  }
    public void setId(int id) {  this.id = id;   }
    public String getFirstName() {    return firstName;  }
    public void setFirstName(String firstName) {     this.firstName = firstName; }
    public String getLastName() {     return lastName; }
    public void setLastName(String lastName) {    this.lastName = lastName; }
    public String getEmail() { return email;  }
    public void setEmail(String email) {     this.email = email; }
    public String getPassword() {     return password; }
    public void setPassword(String password) {    this.password = password;}
    public User() { }
    public User(int id, String firstName, String lastName, String email, String password) {   this.id = id;   this.firstName = firstName;   this.lastName = lastName;   this.email = email;   this.password = password;}

    @Override
    public String toString() {  return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email   + ", password=" + password + "]";   }

}
