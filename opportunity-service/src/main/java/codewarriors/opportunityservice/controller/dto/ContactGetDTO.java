package codewarriors.opportunityservice.controller.dto;

public class ContactGetDTO {
    private long idContact;
    //private static int idCounter = 1;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private AccountOppAndContactGetDTO accountOppAndContactGetDTO;

    public ContactGetDTO(){

    }

    public ContactGetDTO(long idContact, String name, String phoneNumber, String email, String companyName, AccountOppAndContactGetDTO accountOppAndContactGetDTO) {
        this.idContact = idContact;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.accountOppAndContactGetDTO = accountOppAndContactGetDTO;
    }

    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
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

    public AccountOppAndContactGetDTO getAccountOppAndContactGetDTO() {
        return accountOppAndContactGetDTO;
    }

    public void setAccountOppAndContactGetDTO(AccountOppAndContactGetDTO accountOppAndContactGetDTO) {
        this.accountOppAndContactGetDTO = accountOppAndContactGetDTO;
    }
}
