package com.alamgir.f_entity_relationship_mapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class User3 {

    @Id
    @SequenceGenerator(name = "user1_id_seq", sequenceName = "user1_id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user1_id_seq")
    private int uid;

    private String name;
    private String gender;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles_join", joinColumns = @JoinColumn(name = "uid"), inverseJoinColumns = @JoinColumn(name = "rid"))
    List<Roles> roles = new ArrayList<>();


    public int getUid() { return uid; }
    public void setUid(int uid) { this.uid = uid;}
    public String getName() {   return name;}
    public void setName(String name) {  this.name = name;}
    public String getGender() {   return gender; }
    public void setGender(String gender) {   this.gender = gender; }
    public List<Roles> getRoles() {   return roles;}
    public void setRoles(List<Roles> roles) {   this.roles = roles;}
    public User3(int uid, String name, String gender, List<Roles> roles) {  this.uid = uid;  this.name = name;  this.gender = gender;  this.roles = roles;}
    public User3() { } 

}
