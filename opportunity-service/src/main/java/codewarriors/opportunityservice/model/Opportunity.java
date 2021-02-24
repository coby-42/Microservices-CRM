package codewarriors.opportunityservice.model;



import codewarriors.opportunityservice.controller.dto.SalesRepGetDTO;
import codewarriors.opportunityservice.enums.Product;
import codewarriors.opportunityservice.enums.Status;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

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
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Opportunity(Product product, int quantity, Contact contact, Status status, Long salesRepId, Optional<Account> account) {
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, Long salesRepId, Account account) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}