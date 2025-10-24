package com.alamgir.l_spring_boot_security_jwt.user.response;

public class UserLoginResponse {
    private String email;
    private String token;

   
    public String getEmail() {    return email;}
    public void setEmail(String email) {     this.email = email;  }
    public String getToken() { return token; }
    public void setToken(String token) {this.token = token;   }
    public UserLoginResponse(String email, String token) {    this.email = email;   this.token = token; }

    
    

}
