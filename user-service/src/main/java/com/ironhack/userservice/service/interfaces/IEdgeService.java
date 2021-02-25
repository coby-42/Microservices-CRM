package com.ironhack.userservice.service.interfaces;

import com.ironhack.userservice.controller.DTO.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IEdgeService {

    List<AccountGetDTO> getAllAccounts();

    AccountGetDTO getAccountById(Long id);

    void createAccount(AccountGetDTO accountGetDTO);

    List<LeadGetDTO> getLeads();

    LeadGetDTO postLead(LeadPostDTO leadPostDTO);

    LeadGetDTO getLead(Long id);

    LeadGetDTO putLead(Long id, LeadPostDTO leadPostDTO);

    LeadGetDTO deleteLead(Long id);

    OppGetDTO getOppById(Long id);

    void createOpp(OppPostDTO oppPostDTO);

    void updateOppCloseLost(Long id);

    void updateOppCloseWon(Long id);

    List<Object[]> getOppBySalesRep();

    List<Object[]> getClosedWonBySalesRep();

    List<Object[]> getClosedLostBySalesRep();

    List<Object[]> getOpenBySalesRep();

    List<Object[]> getOppByProduct();

    List<Object[]> getClosedWonByProduct();

    List<Object[]> getClosedLostByProduct();

    List<Object[]> getOpenByProduct();

    List<Object[]> getOppByCountry();

    List<Object[]> getClosedWonByCountry();

    List<Object[]> getClosedLostByCountry();

    List<Object[]> getOpenByCountry();

    List<Object[]> getOppByCity();

    List<Object[]> getClosedWonByCity();

    List<Object[]> getClosedLostByCity();

    List<Object[]> getOpenByCity();

    List<Object[]> getOppByIndustry();

    List<Object[]> getClosedWonByIndustry();

    List<Object[]> getClosedLostByIndustry();

    List<Object[]> getOpenByIndustry();

    List<Object[]> getMeanQuantityOfOrders();

    List<Object[]> getMedianQuantityOfOrders();

    List<Object[]> getMaxQuantityOfOrders();

    List<Object[]> getMinQuantityOfOrders();

    List<Object[]> getAverageOpportunitiesInAccount();

    List<Object[]> getMaxOpportunitiesInAccount();

    List<Object[]> getMinOpportunitiesInAccount();
}
