package com.alamgir.f_entity_relationship_mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    
    private String email;
    private String phone;

    public int getPid() { return pid;}
    public void setPid(int pid) {  this.pid = pid;  }
    public String getEmail() {  return email; }
    public void setEmail(String email) {  this.email = email;}
    public String getPhone() {  return phone; }
    public void setPhone(String phone) {  this.phone = phone;}
    public Profile(){}
    public Profile(int pid, String email, String phone) { this.pid = pid;  this.email = email;  this.phone = phone; }

    

}
