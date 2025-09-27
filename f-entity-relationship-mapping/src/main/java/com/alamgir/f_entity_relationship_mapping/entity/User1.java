package com.alamgir.f_entity_relationship_mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "user1")
public class User1 {

    @Id

    @SequenceGenerator(name = "user1_id_seq", sequenceName = "user1_id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user1_id_seq")
    private int uid;
    
    private String name;
    private String gender;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "profile_pid")
    private Profile profile;

    public int getUid() { return uid;}
    public void setUid(int uid) {    this.uid = uid;}
    public String getName() {   return name;}
    public void setName(String name) {  this.name = name;}
    public String getGender() {  return gender;}
    public void setGender(String gender) { this.gender = gender;}
    public Profile getProfile() { return profile;}
    public void setProfile(Profile profile) { this.profile = profile; }
    public User1(int uid, String name, String gender, Profile profile) {   this.uid = uid;   this.name = name;   this.gender = gender;this.profile = profile;}
    public User1() {}

}
