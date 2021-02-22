package codewarriors.opportunityservice.controller.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;

import java.util.List;

public interface IOpportunityController {

    OppGetDTO getOppById(Long id) ;
    public List<Object[]> getOppBySalesRep();
}
