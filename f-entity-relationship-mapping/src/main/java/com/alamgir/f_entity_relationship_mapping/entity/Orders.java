package com.alamgir.f_entity_relationship_mapping.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private LocalDateTime orderDate;
    private String name;
/* 
        @ManyToOne(cascade =CascadeType.ALL)
        @JoinColumn(name = "user_uid")
        private User2 user2;
    */


    public int getOid() {return oid;}
    public void setOid(int oid) {   this.oid = oid;}
    public LocalDateTime getOrderDate() {  return orderDate;}
    public void setOrderDate(LocalDateTime orderDate) {  this.orderDate = orderDate; }
    public String getName() {   return name; }
    public void setName(String name) {  this.name = name;  }
    public Orders(int oid, LocalDateTime orderDate, String name) {   this.oid = oid;this.orderDate = orderDate; this.name = name;}
    public Orders() {}
    
}
