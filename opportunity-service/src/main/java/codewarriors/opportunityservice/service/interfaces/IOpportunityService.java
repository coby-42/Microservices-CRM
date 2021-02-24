package codewarriors.opportunityservice.service.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;
import codewarriors.opportunityservice.controller.dto.OppPostDTO;

import java.util.List;

public interface IOpportunityService {

    OppGetDTO createOpp (OppPostDTO oppPostDTO);

    OppGetDTO updateOppCloseLost(Long id);

    OppGetDTO updateOppCloseWon(Long id);

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

}
