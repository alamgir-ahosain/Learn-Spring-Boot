package com.alamgir.k_exception_handling.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class User {

    @NotNull(message = "Should not be Null")
    @NotEmpty(message = "Should not be Empty")
    @NotBlank(message = "Should no be Blank")
    private String id;

    @NotNull(message = "Should not be Null")
    @NotEmpty(message = "Should not be Empty")
    @NotBlank(message = "Should no be Blank")
    private String name;

    @NotNull(message = "Should not be Null")
    @NotEmpty(message = "Should not be Empty")
    @NotBlank(message = "Should no be Blank")
    @Email(message = "Invalid Email Id")
    private String email;



    public String getId() {    return id; }
    public void setId(String id) {     this.id = id;   }
    public String getName() {   return name;  }
    public void setName(String name) { this.name = name;  }
    public String getEmail() {   return email; }
    public void setEmail(String email) {this.email = email;  }
}
