package codewarriors.opportunityservice.service.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;
import codewarriors.opportunityservice.controller.dto.OppPostDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOpportunityService {

    void createOpp (OppPostDTO oppPostDTO);

    void updateOppCloseLost(Long id);

    void updateOppCloseWon(Long id);

//    ----------------------------------------------------------------------------
//    ---------------------------------By SalesRep--------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppBySalesRep();
    public List<Object[]> getClosedWonBySalesRep();
    public List<Object[]> getClosedLostBySalesRep();
    public List<Object[]> getOpenBySalesRep();

//    ----------------------------------------------------------------------------
//    ---------------------------------By Product --------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppByProduct();
    public List<Object[]> getClosedWonByProduct();
    public List<Object[]> getClosedLostByProduct();
    public List<Object[]> getOpenByProduct();

//    ----------------------------------------------------------------------------
//    ---------------------------------By Country --------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppByCountry();
    public List<Object[]> getClosedWonByCountry();
    public List<Object[]> getClosedLostByCountry();
    public List<Object[]> getOpenByCountry();

//    ----------------------------------------------------------------------------
//    ---------------------------------By City -----------------------------------
//    ----------------------------------------------------------------------------
    public List<Object[]> getOppByCity();
    public List<Object[]> getClosedWonByCity();
    public List<Object[]> getClosedLostByCity();
    public List<Object[]> getOpenByCity();

//    ----------------------------------------------------------------------------
//    ---------------------------------By Industry--------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getOppByIndustry();
    public List<Object[]> getClosedWonByIndustry();
    public List<Object[]> getClosedLostByIndustry();
    public List<Object[]> getOpenByIndustry();

//    ----------------------------------------------------------------------------
//    -----------------------------------------------------
//    ----------------------------------------------------------------------------

    public List<Object[]> getMeanQuantityOfOrders();
    public List<Object[]> getMedianQuantityOfOrders();
    public List<Object[]> getMaxQuantityOfOrders();
    public List<Object[]> getMinQuantityOfOrders();

//    ----------------------------------------------------------------------------
//    ----------------------------------------------------------------------------
//    ----------------------------------------------------------------------------


    public List<Object[]> getAverageOpportunitiesInAccount();
    public List<Object[]> getMaxOpportunitiesInAccount();
    public List<Object[]> getMinOpportunitiesInAccount();


}
