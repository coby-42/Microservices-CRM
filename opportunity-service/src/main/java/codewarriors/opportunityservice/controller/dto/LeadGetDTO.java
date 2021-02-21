package codewarriors.opportunityservice.controller.dto;

public class LeadGetDTO {

    private long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private SalesRepGetDTO salesRep;

    public LeadGetDTO(){

    }

    public LeadGetDTO(long id, String name, String phoneNumber, String email,
                      String companyName, SalesRepGetDTO salesRep) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public SalesRepGetDTO getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRepGetDTO salesRep) {
        this.salesRep = salesRep;
    }
}
