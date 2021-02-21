package codewarriors.opportunityservice.controller.dto;
import javax.validation.constraints.NotNull;
import codewarriors.opportunityservice.enums.Status;


public class OppPostDTO {

    private Long leadId;
    @NotNull(message = "A type of product is required")
    private Product product;
    @NotNull(message = "A product´s quantity is required")
    private int quantity;
    @NotNull(message = "A contact is required")
    private ContactGetDTO decisionMaker;
    @NotNull(message = "A status is required")
    private Status status;
    @NotNull(message = "A salesrep is required")
    private Long salesRepId;
    @NotNull(message = "An account is required")
    private Long accountId;

    public OppPostDTO() {

    }

    public OppPostDTO(Long leadId, Product product, int quantity, ContactGetDTO decisionMaker, Status status, Long salesRepId, Long accountId) {
        this.leadId = leadId;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
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

    public Long getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Long salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}