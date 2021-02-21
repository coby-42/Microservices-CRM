package codewarriors.opportunityservice.controller.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;

public interface IOpportunityController {

    OppGetDTO getOppById(Long id) ;
}
