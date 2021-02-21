package codewarriors.opportunityservice.controller.impl;

import codewarriors.opportunityservice.client.AccountClient;
import codewarriors.opportunityservice.client.LeadClient;
import codewarriors.opportunityservice.client.SalesRepClient;
import codewarriors.opportunityservice.controller.dto.*;
import codewarriors.opportunityservice.controller.interfaces.IOpportunityController;
import codewarriors.opportunityservice.enums.Status;
import codewarriors.opportunityservice.model.Contact;
import codewarriors.opportunityservice.model.Opportunity;
import codewarriors.opportunityservice.repository.ContactRepository;
import codewarriors.opportunityservice.repository.OpportunityRepository;
import codewarriors.opportunityservice.service.interfaces.IOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class OpportunityController implements IOpportunityController{

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private IOpportunityService opportunityService;
    @Autowired
    private LeadClient leadClient;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private SalesRepClient salesRepClient;

    @Override
    @GetMapping("/opportunity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OppGetDTO getOppById(@PathVariable long id) {

        if(!opportunityRepository.existsById((int) id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opportunity not found");
        }

        Opportunity opportunity = opportunityRepository.findById((int) id).get();
        AccountGetDTO accountOppAndContactGetDTO = accountClient.getAccountById(opportunity.getAccountId());
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


    @PostMapping("/opportunity/{lead-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public OppGetDTO createOpp (@PathVariable int id, @RequestBody @Valid OppPostDTO oppPostDTO){
        return opportunityService.createOpp(id, oppPostDTO);
    }

    @PutMapping ("/opportunity/close-lost/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public OppGetDTO updateOppCloseLost (@PathVariable int id){
       return opportunityService.updateOppCloseLost(id);
    }

    @PutMapping ("/opportunity/close-won/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public OppGetDTO updateOppCloseWon (@PathVariable int id){
        return opportunityService.updateOppCloseWon(id);
    }
}
