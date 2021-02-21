package codewarriors.opportunityservice.controller.dto;

import java.util.List;

public class SalesRepGetDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String roles;

    public SalesRepGetDTO() {
    }

    public SalesRepGetDTO(Long id, String username, String firstName, String lastName, String roles) {
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
