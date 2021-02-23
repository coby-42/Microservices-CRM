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
import java.util.List;

@RestController
public class OpportunityController implements IOpportunityController {

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
    public OppGetDTO getOppById(@PathVariable Long id) {

        if (!opportunityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opportunity not found");
        }

        Opportunity opportunity = opportunityRepository.findById(id).get();

        ContactGetDTO contactGetDTO = new ContactGetDTO(opportunity.getDecisionMaker().getIdContact(),
                opportunity.getDecisionMaker().getName(),
                opportunity.getDecisionMaker().getPhoneNumber(),
                opportunity.getDecisionMaker().getEmail(),
                opportunity.getDecisionMaker().getCompanyName(),
                opportunity.getDecisionMaker().getAccountId());


        OppGetDTO oppGetDTO = new OppGetDTO(opportunity.getId(),
                opportunity.getProduct(),
                opportunity.getQuantity(),
                contactGetDTO,
                opportunity.getStatus(),
                opportunity.getSalesRepId(),
                opportunity.getAccountId());
        return oppGetDTO;
    }


    @PostMapping("/opportunity")
    @ResponseStatus(HttpStatus.CREATED)
    public OppGetDTO createOpp(@RequestBody @Valid OppPostDTO oppPostDTO) {
        return opportunityService.createOpp(oppPostDTO);
    }

    @PutMapping("/opportunity/close-lost/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public OppGetDTO updateOppCloseLost(@PathVariable Long id) {
        return opportunityService.updateOppCloseLost(id);
    }

    @PutMapping("/opportunity/close-won/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public OppGetDTO updateOppCloseWon(@PathVariable Long id) {
        return opportunityService.updateOppCloseWon(id);
    }

//    ----------------------------------------------------------------------------
//    ---------------------------------By SalesRep--------------------------------
//    ----------------------------------------------------------------------------

    @Override
    @GetMapping("/report/opportunity/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOppBySalesRep() {
        return opportunityService.getOppBySalesRep();
    }

    @Override
    @GetMapping("/report/closedWon/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonBySalesRep() {
        return opportunityService.getClosedWonBySalesRep();
    }

    @Override
    @GetMapping("/report/closedLost/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostBySalesRep() {
        return opportunityService.getClosedLostBySalesRep();
    }

    @Override
    @GetMapping("/report/open/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenBySalesRep() {
        return opportunityService.getOpenBySalesRep();
    }

//    ----------------------------------------------------------------------------
//    ---------------------------------By Product --------------------------------
//    ----------------------------------------------------------------------------

    @Override
    @GetMapping("/report/opportunity/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOppByProduct() {
        return opportunityService.getOppByProduct();
    }

    @Override
    @GetMapping("/report/closedWon/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonByProduct() {
        return opportunityService.getClosedWonByProduct();
    }

    @Override
    @GetMapping("/report/closedLost/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostByProduct() {
        return opportunityService.getClosedLostByProduct();
    }

    @Override
    @GetMapping("/report/open/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenByProduct() {
        return opportunityService.getOpenByProduct();
    }



}
