package com.alamgir.l_spring_boot_security_jwt.user.request;

import jakarta.validation.constraints.NotBlank;

public class UserChangePasswordRequest {

    private String password;

    @NotBlank(message = "newPassword can't be empty")
    @NotBlank(message = "newPassword can't be null ")
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
