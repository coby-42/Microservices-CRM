package com.ironhack.userservice.controller.DTO;

import com.ironhack.userservice.model.Role;

import java.util.Set;

public class AdminGetDTO {
    private Long id;
    private String username;
    private Set<Role> roles;

    public AdminGetDTO() {
    }

    public AdminGetDTO(Long id, String username, Set<Role> roles) {
        this.id = id;
        this.username = username;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
