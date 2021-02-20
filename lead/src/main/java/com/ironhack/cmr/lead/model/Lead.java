package com.ironhack.cmr.lead.model;


import com.ironhack.cmr.lead.dto.LeadPostDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private Integer salesRepId;


    public Lead(){
    }

    public Lead(LeadPostDTO leadPostDTO) {
        setName(leadPostDTO.getName());
        setPhoneNumber(leadPostDTO.getPhoneNumber());
        setEmail(leadPostDTO.getEmail());
        setCompanyName(leadPostDTO.getCompanyName());
        setSalesRepId(leadPostDTO.getSalesRepId());
    }

    public Lead(Integer id, LeadPostDTO leadPostDTO) {
        this(leadPostDTO);
        setId(id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Integer salesRep) {
        this.salesRepId = salesRep;
    }

    @Override
    public String toString() {
        return "Lead with id  " + id +
                " whose name is " + name + '\'' +
                " has the following phone number " + phoneNumber + '\'' +
                ", email address " + email + '\'' +
                " and belongs to the company " + companyName ;
    }

    public String shortPrint() {
        return id + " || " + name;
    }
}