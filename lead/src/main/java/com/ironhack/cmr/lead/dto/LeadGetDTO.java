package com.ironhack.cmr.lead.dto;


import com.ironhack.cmr.lead.model.Lead;

public class LeadGetDTO {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private Integer salesRepId;


    public LeadGetDTO(){
    }

    public LeadGetDTO(Lead lead) {
        setId(lead.getId());
        setName(lead.getName());
        setPhoneNumber(lead.getPhoneNumber());
        setEmail(lead.getEmail());
        setCompanyName(lead.getCompanyName());
        setSalesRepId(lead.getSalesRepId());
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

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

}