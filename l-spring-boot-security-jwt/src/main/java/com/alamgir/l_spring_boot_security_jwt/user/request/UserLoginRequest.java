package com.alamgir.l_spring_boot_security_jwt.user.request;

public class UserLoginRequest {
    private String email;
    private String password;

    public String getEmail() {return email;  }
    public void setEmail(String email) {this.email = email;  }
    public String getPassword() {    return password; }
    public void setPassword(String password) {this.password = password; }

}
