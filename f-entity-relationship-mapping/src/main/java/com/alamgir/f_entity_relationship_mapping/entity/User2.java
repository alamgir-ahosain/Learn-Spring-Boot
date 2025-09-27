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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class User2 {

    @Id

    @SequenceGenerator(name = "user1_id_seq", sequenceName = "user1_id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user1_id_seq")
    private int uid;

    private String name;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_uid")
    List<Orders> orders = new ArrayList<>();

    public int getUid() { return uid;}
    public void setUid(int uid) {  this.uid = uid;}
    public String getName() {   return name; }
    public void setName(String name) {   this.name = name;}
    public String getGender() {  return gender;}
    public void setGender(String gender) { this.gender = gender; }
    public List<Orders> getOrders() {  return orders;}
    public void setOrders(List<Orders> orders) {   this.orders = orders;}
    public User2(int uid, String name, String gender, List<Orders> orders) { this.uid = uid; this.name = name; this.gender = gender; this.orders = orders;}
    public User2() {}
    

    
}
