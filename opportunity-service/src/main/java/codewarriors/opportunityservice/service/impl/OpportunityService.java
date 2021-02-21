package codewarriors.opportunityservice.service.impl;

import codewarriors.opportunityservice.client.AccountClient;
import codewarriors.opportunityservice.client.LeadClient;
import codewarriors.opportunityservice.client.SalesRepClient;
import codewarriors.opportunityservice.controller.dto.*;
import codewarriors.opportunityservice.enums.Status;
import codewarriors.opportunityservice.model.Contact;
import codewarriors.opportunityservice.model.Opportunity;
import codewarriors.opportunityservice.repository.ContactRepository;
import codewarriors.opportunityservice.repository.OpportunityRepository;
import codewarriors.opportunityservice.service.interfaces.IOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Service
public class OpportunityService implements IOpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private LeadClient leadClient;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private SalesRepClient salesRepClient;

    public OppGetDTO createOpp (@PathVariable long id, @RequestBody @Valid OppPostDTO oppPostDTO) {

        LeadGetDTO leadGetDTO = leadClient.getLeadById(id);
        Contact contact = new Contact();
        contact.setName(leadGetDTO.getName());
        contact.setCompanyName(leadGetDTO.getCompanyName());
        contact.setEmail(leadGetDTO.getEmail());
        contact.setPhoneNumber(leadGetDTO.getPhoneNumber());
        contact.setAccountId(oppPostDTO.getAccountId());
        contactRepository.save(contact);

        AccountOppAndContactGetDTO accountOppAndContactGetDTO = accountClient.getAccountById(oppPostDTO.getAccountId());
        Opportunity opportunity = new Opportunity();
        opportunity.setDecisionMaker(contact);
        opportunity.setProduct(oppPostDTO.getProduct());
        opportunity.setSalesRepId(oppPostDTO.getSalesRepId());
        opportunity.setQuantity(oppPostDTO.getQuantity());
        opportunity.setStatus(oppPostDTO.getStatus());
        opportunity.setAccountId(oppPostDTO.getAccountId());
        opportunityRepository.save(opportunity);

        ContactGetDTO contactGetDTO = new ContactGetDTO(opportunity.getDecisionMaker().getIdContact(),
                                                        opportunity.getDecisionMaker().getName(),
                                                        opportunity.getDecisionMaker().getPhoneNumber(),
                                                        opportunity.getDecisionMaker().getEmail(),
                                                        opportunity.getDecisionMaker().getCompanyName(),
                                                        accountOppAndContactGetDTO);


        OppGetDTO oppGetDTO = new OppGetDTO(opportunity.getId(),
                                            opportunity.getProduct(),
                                            opportunity.getQuantity(),
                                            contactGetDTO,
                                            opportunity.getStatus(),
                                            leadGetDTO.getSalesRep(),
                                            accountOppAndContactGetDTO);

        return oppGetDTO;
    }

        public OppGetDTO updateOppCloseLost (long id) {
        if(!opportunityRepository.findById((int) id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opportunity not found");
        }

        Opportunity opportunity =  opportunityRepository.findById((int) id).get();
        opportunity.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity);

        AccountOppAndContactGetDTO accountOppAndContactGetDTO = accountClient.getAccountById(opportunity.getAccountId());

        SalesRepGetDTO salesRepGetDTO = salesRepClient.getSalesRepById(opportunity.getSalesRepId());

        ContactGetDTO contactGetDTO = new ContactGetDTO(opportunity.getDecisionMaker().getIdContact(),
                                                        opportunity.getDecisionMaker().getName(),
                                                        opportunity.getDecisionMaker().getPhoneNumber(),
                                                        opportunity.getDecisionMaker().getEmail(),
                                                        opportunity.getDecisionMaker().getCompanyName(),
                                                        accountOppAndContactGetDTO);


        OppGetDTO oppGetDTO = new OppGetDTO(opportunity.getId(),
                                            opportunity.getProduct(),
                                            opportunity.getQuantity(),
                                            contactGetDTO,
                                            opportunity.getStatus(),
                                            salesRepGetDTO,
                                            accountOppAndContactGetDTO);

        return oppGetDTO;
    }

    public OppGetDTO updateOppCloseWon (long id) {

        if(!opportunityRepository.findById((int) id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opportunity not found");
        }

        Opportunity opportunity =  opportunityRepository.findById((int) id).get();
        opportunity.setStatus(Status.CLOSED_WON);
        opportunityRepository.save(opportunity);

        AccountOppAndContactGetDTO accountOppAndContactGetDTO = accountClient.getAccountById(opportunity.getAccountId());

        SalesRepGetDTO salesRepGetDTO = salesRepClient.getSalesRepById(opportunity.getSalesRepId());

        ContactGetDTO contactGetDTO = new ContactGetDTO(opportunity.getDecisionMaker().getIdContact(),
                                                        opportunity.getDecisionMaker().getName(),
                                                        opportunity.getDecisionMaker().getPhoneNumber(),
                                                        opportunity.getDecisionMaker().getEmail(),
                                                        opportunity.getDecisionMaker().getCompanyName(),
                                                        accountOppAndContactGetDTO);


        OppGetDTO oppGetDTO = new OppGetDTO(opportunity.getId(),
                                            opportunity.getProduct(),
                                            opportunity.getQuantity(),
                                            contactGetDTO,
                                            opportunity.getStatus(),
                                            salesRepGetDTO,
                                            accountOppAndContactGetDTO);

        return oppGetDTO;
    }
}
