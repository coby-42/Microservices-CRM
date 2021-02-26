package com.ironhack.userservice.service.impl;

import com.ironhack.userservice.clases.Lead;
import com.ironhack.userservice.client.LeadClient;
import com.ironhack.userservice.client.OpportunityClient;
import com.ironhack.userservice.controller.DTO.*;
import com.ironhack.userservice.service.interfaces.IEdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.userservice.clases.Industry.MANUFACTURING;

@Service
public class EdgeService implements IEdgeService {
    @Autowired
    private OpportunityClient opportunityClient;
    @Autowired
    private LeadClient leadClient;

    private final CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

/**   -------------------------------- Account ----------------------------------- **/

    @Override
    public List<AccountGetDTO> getAllAccounts() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("account-service");
        return circuitBreaker.run(()->opportunityClient.getAllAccounts(), throwable -> getAllAccountsFallback());
    }

    @Override
    public AccountGetDTO getAccountById(Long id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("account-service");
        return circuitBreaker.run(()->opportunityClient.getAccountById(id),throwable->getAccountByIdFallback());
    }

    @Override
    public void createAccount(AccountGetDTO accountGetDTO) {
        opportunityClient.createAccount(accountGetDTO);
    }

/**   --------------------------- Account Fallback ------------------------------- **/

    private List<AccountGetDTO> getAllAccountsFallback() {
        List<AccountGetDTO> list=new ArrayList<>();
        list.add(new AccountGetDTO(1L,MANUFACTURING,1,"Barcelona","Spain"));
        return list;
    }

    private AccountGetDTO getAccountByIdFallback() {
        AccountGetDTO result=new AccountGetDTO(1L,MANUFACTURING,1,"Barcelona","Spain");
        return result;
    }

/**   ---------------------------------- Lead ------------------------------------ **/

    @Override
    public List<LeadGetDTO> getLeads() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("lead-service");
        return circuitBreaker.run(()->leadClient.getLeads(),throwable -> getLeadsFallback());
    }

    @Override
    public LeadGetDTO postLead(LeadPostDTO leadPostDTO) {
        return leadClient.postLead(leadPostDTO);
    }

    @Override
    public LeadGetDTO getLead(Long id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("lead-service");
        return circuitBreaker.run(()->leadClient.getLead(id),throwable -> getLeadFallback());
    }

    @Override
    public LeadGetDTO putLead(Long id, LeadPostDTO leadPostDTO) {
        return leadClient.putLead(id, leadPostDTO);
    }

    @Override
    public LeadGetDTO deleteLead(Long id) {
        return leadClient.deleteLead(id);
    }

    /**   ------------------------------ Lead Fallback ------------------------------- **/

    private List<LeadGetDTO> getLeadsFallback() {
        List<LeadGetDTO> result=new ArrayList<>();
        result.add(new LeadGetDTO(new Lead()));
        return result;
    }
    private LeadGetDTO getLeadFallback() {
        LeadGetDTO result=new LeadGetDTO(new Lead());
        return result;
    }
/**   ------------------------------ Opportunity --------------------------------- **/

    @Override
    public OppGetDTO getOppById(Long id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("lead-service");
        return circuitBreaker.run(()->opportunityClient.getOppById(id),throwable -> getOppByIdFallback());
    }

    @Override
    public void createOpp(OppPostDTO oppPostDTO) {
        opportunityClient.createOpp(oppPostDTO);
    }

    @Override
    public void updateOppCloseLost(Long id) {
        opportunityClient.updateOppCloseLost(id);
    }

    @Override
    public void updateOppCloseWon(Long id) {
        opportunityClient.updateOppCloseWon(id);
    }

    /**   -------------------------- Opportunity FallBack ---------------------------- **/

    private OppGetDTO getOppByIdFallback() {
        OppGetDTO result= new OppGetDTO();
        return result;
    }

/**   ----------------------------Reports By SalesRep----------------------------- **/

    @Override
    public List<Object[]> getOppBySalesRep() {
        return opportunityClient.getOppBySalesRep();
    }

    @Override
    public List<Object[]> getClosedWonBySalesRep() {
        return opportunityClient.getClosedWonBySalesRep();
    }

    @Override
    public List<Object[]> getClosedLostBySalesRep() {
        return opportunityClient.getClosedLostBySalesRep();
    }

    @Override
    public List<Object[]> getOpenBySalesRep() {
        return opportunityClient.getOpenBySalesRep();
    }


/**   -------------------------Reports By Product -------------------------------- **/

    @Override
    public List<Object[]> getOppByProduct() {
        return opportunityClient.getOppByProduct();
    }

    @Override
    public List<Object[]> getClosedWonByProduct() {
        return opportunityClient.getClosedWonByProduct();
    }

    @Override
    public List<Object[]> getClosedLostByProduct() {
        return opportunityClient.getClosedLostByProduct();
    }

    @Override
    public List<Object[]> getOpenByProduct() {
        return opportunityClient.getOpenByProduct();
    }

/**   -------------------------Reports By Country -------------------------------- **/

    @Override
    public List<Object[]> getOppByCountry() {
        return opportunityClient.getOppByCountry();
    }

    @Override
    public List<Object[]> getClosedWonByCountry() {
        return opportunityClient.getClosedWonByCountry();
    }

    @Override
    public List<Object[]> getClosedLostByCountry() {
        return opportunityClient.getClosedLostByCountry();
    }

    @Override
    public List<Object[]> getOpenByCountry() {
        return opportunityClient.getOpenByCountry();
    }

/**   ---------------------------Reports By City --------------------------------- **/

    @Override
    public List<Object[]> getOppByCity() {
        return opportunityClient.getOppByCity();
    }

    @Override
    public List<Object[]> getClosedWonByCity() {
        return opportunityClient.getClosedWonByCity();
    }

    @Override
    public List<Object[]> getClosedLostByCity() {
        return opportunityClient.getClosedLostByCity();
    }

    @Override
    public List<Object[]> getOpenByCity() {
        return opportunityClient.getOpenByCity();
    }

/**   ---------------------------------By Industry-------------------------------- **/

    @Override
    public List<Object[]> getOppByIndustry() {
        return opportunityClient.getOppByIndustry();
    }

    @Override
    public List<Object[]> getClosedWonByIndustry() {
        return opportunityClient.getClosedWonByIndustry();
    }

    @Override
    public List<Object[]> getClosedLostByIndustry() {
        return opportunityClient.getClosedLostByIndustry();
    }

    @Override
    public List<Object[]> getOpenByIndustry() {
        return opportunityClient.getOpenByIndustry();
    }

/**   ------------------------------------Stats----------------------------------- **/

    @Override
    public List<Object[]> getMeanQuantityOfOrders() {
        return opportunityClient.getMeanQuantityOfOrders();
    }

    @Override
    public List<Object[]> getMedianQuantityOfOrders() {
        return opportunityClient.getMedianQuantityOfOrders();
    }

    @Override
    public List<Object[]> getMaxQuantityOfOrders() {
        return opportunityClient.getMaxQuantityOfOrders();
    }

    @Override
    public List<Object[]> getMinQuantityOfOrders() {
        return opportunityClient.getMinQuantityOfOrders();
    }

    @Override
    public List<Object[]> getAverageOpportunitiesInAccount() {
        return opportunityClient.getAverageOpportunitiesInAccount();
    }

    @Override
    public List<Object[]> getMaxOpportunitiesInAccount() {
        return opportunityClient.getMaxOpportunitiesInAccount();
    }

    @Override
    public List<Object[]> getMinOpportunitiesInAccount() {
        return opportunityClient.getMinOpportunitiesInAccount();
    }



}
