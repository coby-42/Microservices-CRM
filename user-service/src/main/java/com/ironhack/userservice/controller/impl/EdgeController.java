package com.ironhack.userservice.controller.impl;

import com.ironhack.userservice.client.OpportunityClient;
import com.ironhack.userservice.client.LeadClient;
import com.ironhack.userservice.controller.DTO.*;
import com.ironhack.userservice.service.interfaces.IEdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EdgeController {
    @Autowired
    private OpportunityClient opportunityClient;
    @Autowired
    private LeadClient leadClient;
    @Autowired
    private IEdgeService edgeService;

/**   -------------------------------- Account ----------------------------------- **/

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountGetDTO> getAllAccounts(){
        return edgeService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountGetDTO getAccountById(@PathVariable("id") Long id){
        return edgeService.getAccountById(id);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountGetDTO accountGetDTO) {
        edgeService.createAccount(accountGetDTO);
    }


/**   ---------------------------------- Lead ------------------------------------ **/

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<LeadGetDTO> getLeads(){
        return edgeService.getLeads();
    }

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public LeadGetDTO postLead(@RequestBody @Valid LeadPostDTO leadPostDTO){
        return edgeService.postLead(leadPostDTO);
    }

    @GetMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO getLead(@PathVariable Long id){
        return edgeService.getLead(id);
    }

    @PutMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO putLead(@PathVariable Long id, @RequestBody @Valid LeadPostDTO leadPostDTO){
        return edgeService.putLead(id, leadPostDTO);
    }

    @DeleteMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO deleteLead(@PathVariable Long id){
        return edgeService.deleteLead(id);
    }


/**   ------------------------------ Opportunity --------------------------------- **/

    @GetMapping("/opportunity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OppGetDTO getOppById(@PathVariable Long id) {
        return edgeService.getOppById(id);
    }

    @PostMapping("/opportunity")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOpp(@RequestBody @Valid OppPostDTO oppPostDTO){
        edgeService.createOpp(oppPostDTO);
    }

    @PutMapping("/opportunity/close-lost/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOppCloseLost(@PathVariable Long id){
        edgeService.updateOppCloseLost(id);
    }

    @PutMapping("/opportunity/close-won/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOppCloseWon(@PathVariable Long id){
        edgeService.updateOppCloseWon(id);
    }

/**   ----------------------------Reports By SalesRep----------------------------- **/

    @GetMapping("/report/opportunity/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getOppBySalesRep(){
        return edgeService.getOppBySalesRep();
    }

    @GetMapping("/report/closedWon/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonBySalesRep(){
        return edgeService.getClosedWonBySalesRep();
    }

    @GetMapping("/report/closedLost/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostBySalesRep(){
        return edgeService.getClosedLostBySalesRep();
    }

    @GetMapping("/report/open/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenBySalesRep(){
        return edgeService.getOpenBySalesRep();
    }
/**   -------------------------Reports By Product -------------------------------- **/

    @GetMapping("/report/opportunity/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOppByProduct(){
        return edgeService.getOppByProduct();
    }

    @GetMapping("/report/closedWon/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonByProduct(){
        return edgeService.getClosedWonByProduct();
    }

    @GetMapping("/report/closedLost/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostByProduct(){
        return edgeService.getClosedLostByProduct();
    }

    @GetMapping("/report/open/by-Product")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenByProduct(){
        return edgeService.getOpenByProduct();
    }
/**   -------------------------Reports By Country -------------------------------- **/

    @GetMapping("/report/opportunity/by-Country")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOppByCountry(){
        return edgeService.getOppByCountry();
    }

    @GetMapping("/report/closedWon/by-Country")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonByCountry(){
        return edgeService.getClosedWonByCountry();
    }

    @GetMapping("/report/closedLost/by-Country")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostByCountry(){
        return edgeService.getClosedLostByCountry();
    }

    @GetMapping("/report/open/by-Country")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenByCountry(){
        return edgeService.getOpenByCountry();
    }

/**   ---------------------------Reports By City --------------------------------- **/

    @GetMapping("/report/opportunity/by-City")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOppByCity(){
        return edgeService.getOppByCity();
    }


    @GetMapping("/report/closedWon/by-City")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonByCity(){
        return edgeService.getClosedWonByCity();
    }

    @GetMapping("/report/closedLost/by-City")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostByCity() {
        return edgeService.getClosedLostByCity();
    }

    @GetMapping("/report/open/by-City")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenByCity(){
        return edgeService.getOpenByCity();
    }

/**   ---------------------------------By Industry-------------------------------- **/

    @GetMapping("/report/opportunity/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOppByIndustry(){
        return edgeService.getOppByIndustry();
    }

    @GetMapping("/report/closedWon/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedWonByIndustry(){
        return edgeService.getClosedWonByIndustry();
    }

    @GetMapping("/report/closedLost/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getClosedLostByIndustry(){
        return edgeService.getClosedLostByIndustry();
    }

    @GetMapping("/report/open/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpenByIndustry(){
        return edgeService.getOpenByIndustry();
    }

/**   ------------------------------------Stats----------------------------------- **/
    @GetMapping("/report/meanQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getMeanQuantityOfOrders(){
        return edgeService.getMeanQuantityOfOrders();
    }

    @GetMapping("/report/medianQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getMedianQuantityOfOrders(){
        return edgeService.getMedianQuantityOfOrders();
    }

    @GetMapping("/report/maxQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getMaxQuantityOfOrders(){
        return edgeService.getMaxQuantityOfOrders();
    }

    @GetMapping("/report/minQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getMinQuantityOfOrders(){
        return edgeService.getMinQuantityOfOrders();
    }

    @GetMapping("/report/averageOpportunitiesInAccount")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getAverageOpportunitiesInAccount(){
        return edgeService.getAverageOpportunitiesInAccount();
    }

    @GetMapping("/report/maxOpportunitiesInAccount")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getMaxOpportunitiesInAccount(){
        return edgeService.getMaxOpportunitiesInAccount();
    }

    @GetMapping("/report/minOpportunitiesInAccount")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getMinOpportunitiesInAccount(){
        return edgeService.getMinOpportunitiesInAccount();
    }
}
