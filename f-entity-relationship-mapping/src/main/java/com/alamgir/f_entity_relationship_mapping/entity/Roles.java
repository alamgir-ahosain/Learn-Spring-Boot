package com.alamgir.f_entity_relationship_mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String name;
    private String description;


    public int getRid() { return rid;}
    public void setRid(int rid) { this.rid = rid; }
    public String getName() { return name;}
    public void setName(String name) {  this.name = name; }
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public Roles(int rid, String name,String description) {   this.rid = rid;   this.name = name; this.description=description;}
    public Roles() { }
    

}
