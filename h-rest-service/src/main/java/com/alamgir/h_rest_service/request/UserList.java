package com.alamgir.h_rest_service.request;

import java.util.List;

import com.alamgir.h_rest_service.responce.UserResponce;

public class UserList {
    private String name;
    private List<UserResponce> userResponces;

    public String getName() {  return name; }
    public void setName(String name) {  this.name = name;  }
    public List<UserResponce> getUserResponces() { return userResponces; }
    public void setUserResponces(List<UserResponce> userResponces) {   this.userResponces = userResponces;}

}
