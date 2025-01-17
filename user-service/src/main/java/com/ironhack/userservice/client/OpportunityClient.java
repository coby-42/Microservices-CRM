package com.ironhack.userservice.client;

import com.ironhack.userservice.controller.DTO.AccountGetDTO;
import com.ironhack.userservice.controller.DTO.OppGetDTO;
import com.ironhack.userservice.controller.DTO.OppPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("opportunity-service")
public interface OpportunityClient {

/**   -----------------------------------Account---------------------------------- **/

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    List<AccountGetDTO> getAllAccounts();

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    AccountGetDTO getAccountById(@PathVariable Long id);

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    void createAccount(@RequestBody AccountGetDTO accountGetDTO) ;


/**   ---------------------------------Opportunity-------------------------------- **/


    @GetMapping("/opportunity/{id}")
    @ResponseStatus(HttpStatus.OK)
    OppGetDTO getOppById(@PathVariable Long id) ;

    @PostMapping("/opportunity")
    @ResponseStatus(HttpStatus.CREATED)
    void createOpp(@RequestBody @Valid OppPostDTO oppPostDTO);

    @PutMapping("/opportunity/close-lost/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateOppCloseLost(@PathVariable Long id);

    @PutMapping("/opportunity/close-won/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateOppCloseWon(@PathVariable Long id);


/**   ---------------------------------By SalesRep-------------------------------- **/


    @GetMapping("/report/opportunity/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getOppBySalesRep();

    @GetMapping("/report/closedWon/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedWonBySalesRep();

    @GetMapping("/report/closedLost/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedLostBySalesRep();

    @GetMapping("/report/open/by-salesRep")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOpenBySalesRep();


/**   ---------------------------------By Product -------------------------------- **/


    @GetMapping("/report/opportunity/by-Product")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOppByProduct();

    @GetMapping("/report/closedWon/by-Product")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedWonByProduct();

    @GetMapping("/report/closedLost/by-Product")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedLostByProduct();

    @GetMapping("/report/open/by-Product")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOpenByProduct();

/**   ---------------------------------By Country -------------------------------- **/

    @GetMapping("/report/opportunity/by-Country")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOppByCountry();

    @GetMapping("/report/closedWon/by-Country")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedWonByCountry();

    @GetMapping("/report/closedLost/by-Country")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedLostByCountry();

    @GetMapping("/report/open/by-Country")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOpenByCountry();

/**   ---------------------------------By City ----------------------------------- **/


    @GetMapping("/report/opportunity/by-City")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOppByCity();


    @GetMapping("/report/closedWon/by-City")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedWonByCity();

    @GetMapping("/report/closedLost/by-City")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedLostByCity() ;

    @GetMapping("/report/open/by-City")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOpenByCity();


/**   -------------------------Reports By Industry-------------------------------- **/


    @GetMapping("/report/opportunity/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOppByIndustry();

    @GetMapping("/report/closedWon/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedWonByIndustry();

    @GetMapping("/report/closedLost/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getClosedLostByIndustry();

    @GetMapping("/report/open/by-Industry")
    @ResponseStatus(HttpStatus.OK)
    List <Object[]> getOpenByIndustry();


/**   ------------------------------------Stats----------------------------------- **/

    @GetMapping("/report/meanQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getMeanQuantityOfOrders();

    @GetMapping("/report/medianQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getMedianQuantityOfOrders();

    @GetMapping("/report/maxQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getMaxQuantityOfOrders();

    @GetMapping("/report/minQuantityOfOrders")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getMinQuantityOfOrders();

    @GetMapping("/report/averageOpportunitiesInAccount")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getAverageOpportunitiesInAccount();

    @GetMapping("/report/maxOpportunitiesInAccount")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getMaxOpportunitiesInAccount();

    @GetMapping("/report/minOpportunitiesInAccount")
    @ResponseStatus(HttpStatus.OK)
    List<Object[]> getMinOpportunitiesInAccount();
}
