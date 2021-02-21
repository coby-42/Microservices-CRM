package com.ironhack.userservice.controller.DTO;

import org.hibernate.validator.constraints.Length;

public class SalesRepPostDTO {
    @Length(min = 6, max = 20, message = "Username must have between 6 and 20 characters")
    private String username;
    @Length(min = 5, max = 20, message = "Password must have between 6 and 20 characters")
    private String password;

    @Length(min = 3, max = 40, message = "First Names must have between 3 and 40 characters")
    private String firstName;
    @Length(min = 3, max = 40, message = "Last Names must have between 3 and 40 characters")
    private String lastName;

    public SalesRepPostDTO() {
    }

    public SalesRepPostDTO(@Length(min = 6, max = 20, message = "Username must have between 6 and 20 characters") String username, @Length(min = 6, max = 20, message = "Password must have between 6 and 20 characters") String password, @Length(min = 3, max = 40, message = "First Names must have between 3 and 40 characters") String firstName, @Length(min = 3, max = 40, message = "Last Names must have between 3 and 40 characters") String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
