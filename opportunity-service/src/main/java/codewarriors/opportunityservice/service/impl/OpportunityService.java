package codewarriors.opportunityservice.service.impl;

import codewarriors.opportunityservice.client.LeadClient;
import codewarriors.opportunityservice.client.SalesRepClient;
import codewarriors.opportunityservice.controller.dto.*;
import codewarriors.opportunityservice.enums.Status;
import codewarriors.opportunityservice.model.Account;
import codewarriors.opportunityservice.model.Contact;
import codewarriors.opportunityservice.model.Opportunity;
import codewarriors.opportunityservice.repository.AccountRepository;
import codewarriors.opportunityservice.repository.ContactRepository;
import codewarriors.opportunityservice.repository.OpportunityRepository;
import codewarriors.opportunityservice.service.interfaces.IOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService implements IOpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private LeadClient leadClient;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private SalesRepClient salesRepClient;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    public void createOpp (@RequestBody @Valid OppPostDTO oppPostDTO) {

        LeadGetDTO leadGetDTO = leadClient.getLeadById(oppPostDTO.getLeadId());
        Contact contact = new Contact();
        contact.setName(leadGetDTO.getName());
        contact.setCompanyName(leadGetDTO.getCompanyName());
        contact.setEmail(leadGetDTO.getEmail());
        contact.setPhoneNumber(leadGetDTO.getPhoneNumber());
        contact.setAccountId(oppPostDTO.getAccountId());
        contactRepository.save(contact);

        Optional<Account> account = accountRepository.findById(oppPostDTO.getAccountId());


        Opportunity opportunity = new Opportunity (oppPostDTO.getProduct(),
                                                    oppPostDTO.getQuantity(),
                                                    contact,
                                                    oppPostDTO.getStatus(),
                                                    oppPostDTO.getSalesRepId(),
                                                    account.get());

        opportunityRepository.save(opportunity);


    }

        public void updateOppCloseLost (Long id) {
        if(!opportunityRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opportunity not found");
        }

        Opportunity opportunity =  opportunityRepository.findById(id).get();
        opportunity.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity);

    }

    public void updateOppCloseWon (Long id) {

        if(!opportunityRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opportunity not found");
        }

        Opportunity opportunity =  opportunityRepository.findById(id).get();
        opportunity.setStatus(Status.CLOSED_WON);
        opportunityRepository.save(opportunity);

    }

//    ----------------------------------------------------------------------------
//    ---------------------------------By SalesRep--------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppBySalesRep(){
        return opportunityRepository.countOpportunitiesBySalesRep();
    }
    public List<Object[]> getClosedWonBySalesRep(){
        return opportunityRepository.countOpportunitiesBySalesRepClosedWon();
    }
    public List<Object[]> getClosedLostBySalesRep(){
        return opportunityRepository.countOpportunitiesBySalesRepClosedLost();
    }
    public List<Object[]> getOpenBySalesRep(){
        return opportunityRepository.countOpportunitiesBySalesRepOpen();
    }

//    ----------------------------------------------------------------------------
//    ---------------------------------By Product --------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppByProduct(){
        return opportunityRepository.countOpportunitiesByProduct();
    }
    public List<Object[]> getClosedWonByProduct(){
        return opportunityRepository.countOpportunitiesByProductClosedWon();
    }
    public List<Object[]> getClosedLostByProduct(){
        return opportunityRepository.countOpportunitiesByProductClosedLost();
    }
    public List<Object[]> getOpenByProduct(){
        return opportunityRepository.countOpportunitiesByProductOpen();
    }

//    ----------------------------------------------------------------------------
//    ---------------------------------By Country --------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppByCountry(){
      return opportunityRepository.countOpportunitiesByCountry();
    }
    public List<Object[]> getClosedWonByCountry(){
      return opportunityRepository.countOpportunitiesByCountryClosedWon();
    }
    public List<Object[]> getClosedLostByCountry(){
        return opportunityRepository.countOpportunitiesByCountryClosedLost();
    }
    public List<Object[]> getOpenByCountry(){
        return  opportunityRepository.countOpportunitiesByCountryOpen();
    }
}
