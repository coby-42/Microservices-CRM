package codewarriors.opportunityservice.controller.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;

import java.util.List;

public interface IOpportunityController {

    OppGetDTO getOppById(Long id) ;

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
