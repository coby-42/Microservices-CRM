package codewarriors.opportunityservice.service.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;
import codewarriors.opportunityservice.controller.dto.OppPostDTO;

import java.util.List;

public interface IOpportunityService {

    OppGetDTO createOpp (OppPostDTO oppPostDTO);

    OppGetDTO updateOppCloseLost(Long id);

    OppGetDTO updateOppCloseWon(Long id);

    public List<Object[]> getOppBySalesRep();
}
