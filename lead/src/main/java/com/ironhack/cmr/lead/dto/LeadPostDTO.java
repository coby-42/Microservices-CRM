package com.ironhack.cmr.lead.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class LeadPostDTO {
    @NotEmpty(message = "name can't be empty")
    private String name;
    @Pattern(regexp = "\\+?(?:\\d[\\s.-]*){9,13}", message = "Invalid phone number format")
    private String phoneNumber;
    @Pattern(regexp = ".+@(?:[^.\\s]+.)+[^.\\s]+", message = "Invalid email format")
    private String email;
    @NotEmpty(message = "companyName can't be empty")
    private String companyName;
    @NotNull(message = "salesRepId can't be null")
    private Integer salesRepId;


    public LeadPostDTO(){
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