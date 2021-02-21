package codewarriors.opportunityservice.controller.dto;

import codewarriors.opportunityservice.enums.Product;
import codewarriors.opportunityservice.enums.Status;

public class OppGetDTO {

    private Long id;
    private Product product;
    private int quantity;
    private ContactGetDTO decisionMaker;
    private Status status;
    private Long salesRep;
    private Long accountId;

    public OppGetDTO(){

    }

    public OppGetDTO(Long id, Product product, int quantity, ContactGetDTO decisionMaker, Status status, Long salesRep, Long accountId) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRep = salesRep;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ContactGetDTO getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(ContactGetDTO decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRep = salesRep;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
