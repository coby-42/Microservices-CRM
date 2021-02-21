package codewarriors.opportunityservice.controller.dto;

import codewarriors.opportunityservice.enums.Product;
import codewarriors.opportunityservice.enums.Status;

import javax.validation.constraints.NotNull;

public class OppPostDTO {

    private long leadId;
    @NotNull(message = "A type of product is required")
    private Product product;
    @NotNull(message = "A product´s quantity is required")
    private int quantity;
    @NotNull(message = "A contact is required")
    private ContactGetDTO decisionMaker;
    @NotNull(message = "A status is required")
    private Status status;
    @NotNull(message = "A salesrep is required")
    private long salesRepId;
    @NotNull(message = "An account is required")
    private long accountId;

    public OppPostDTO() {

    }

    public OppPostDTO(long leadId, @NotNull(message = "A type of product is required") Product product,
                      @NotNull(message = "A product´s quantity is required") int quantity,
                      @NotNull(message = "A contact is required") ContactGetDTO decisionMaker,
                      @NotNull(message = "A status is required") Status status,
                      @NotNull(message = "A salesrep is required") long salesRepId,
                      @NotNull(message = "An account is required") long accountId) {
        this.leadId = leadId;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
    }

    public long getLeadId() {
        return leadId;
    }

    public void setLeadId(long leadId) {
        this.leadId = leadId;
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

    public long getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(long salesRepId) {
        this.salesRepId = salesRepId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}