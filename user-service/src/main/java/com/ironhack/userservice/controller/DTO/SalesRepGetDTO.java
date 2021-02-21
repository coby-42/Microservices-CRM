package com.ironhack.userservice.controller.DTO;

import com.ironhack.userservice.model.Role;

import java.util.Set;

public class SalesRepGetDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Set<String> roles;

    public SalesRepGetDTO() {
    }

    public SalesRepGetDTO(Long id, String username, String firstName, String lastName, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

