package com.alamgir.l_spring_boot_security_jwt.user.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_info")
public class User implements UserDetails {

  @Id
  @NotBlank(message = "Email can't be empty")
  @NotNull(message = "Email Can't be Null")
  @Column(unique = true, nullable = false)
  private String email;

  @NotBlank(message = "Name can't be empty")
  @NotNull(message = "Name can't be null ")
  private String name;

  @NotBlank(message = "Password can't be empty")
  @NotBlank(message = "Password can't be null ")
  @Column(nullable = false)
  private String password;
  

  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name;}
  public String getPassword() {return password; }
  public void setPassword(String password) {this.password = password; }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {return null;}


  // !retrun the username used to authenticate the user
  @Override
  public String getUsername() {return email;}

}

/*
   CREATE TABLE user_info (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255),
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL
   );
 
 */