package codewarriors.opportunityservice.model;



import codewarriors.opportunityservice.controller.dto.SalesRepGetDTO;
import codewarriors.opportunityservice.enums.Product;
import codewarriors.opportunityservice.enums.Status;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private static int ID_COUNTER = 1;
    @Enumerated(EnumType.STRING)
    Product product;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "contact_id")
    Contact decisionMaker;
    @Enumerated(EnumType.STRING)
    Status status;
    private Long salesRepId;
    private Long accountId;

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, Long salesRepId, Long accountId) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
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

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}