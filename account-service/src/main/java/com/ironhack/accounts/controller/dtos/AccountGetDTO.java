package com.ironhack.accounts.controller.dtos;

import com.ironhack.accounts.enums.*;
import org.springframework.http.*;
import org.springframework.web.server.*;

public class AccountGetDTO {

    private Integer id;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;

    public AccountGetDTO(Integer id, String industry, int employeeCount, String city, String country) {
        this.id = id;
        trySetIndustry(industry);
        setEmployeeCount(employeeCount);
        this.city = city;
        this.country = country;
    }

    public AccountGetDTO(String industry, int employeeCount, String city, String country) {
        trySetIndustry(industry);
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
    }

    private void trySetIndustry(String industry) {
        try {
            this.industry = Industry.valueOf(industry.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Industry not valid");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        if (employeeCount > 0) {
            this.employeeCount = employeeCount;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Number of employees must be higher than zero");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
