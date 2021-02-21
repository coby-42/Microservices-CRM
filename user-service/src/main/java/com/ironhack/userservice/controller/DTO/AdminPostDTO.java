package com.ironhack.userservice.controller.DTO;

import org.hibernate.validator.constraints.Length;

public class AdminPostDTO {
    @Length(min = 6, max = 20, message = "Username must have between 6 and 20 characters")
    private String username;
    @Length(min = 6, max = 20, message = "Password must have between 6 and 20 characters")
    private String password;

    public AdminPostDTO() {
    }

    public AdminPostDTO(@Length(min = 6, max = 20, message = "Username must have between 6 and 20 characters") String username, @Length(min = 6, max = 20, message = "Password must have between 6 and 20 characters") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
