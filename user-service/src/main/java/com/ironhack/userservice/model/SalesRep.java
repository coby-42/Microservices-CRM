package com.ironhack.userservice.model;

import javax.persistence.Entity;

@Entity
public class SalesRep extends User{
    private String firstName;
    private String lastName;


    public SalesRep() {
    }

    public SalesRep(String username, String password, String firstName, String lastName) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }



//  Getters and setters
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
