package codewarriors.opportunityservice.service.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;
import codewarriors.opportunityservice.controller.dto.OppPostDTO;

public interface IOpportunityService {

    OppGetDTO createOpp (Long id, OppPostDTO oppPostDTO);

    OppGetDTO updateOppCloseLost(Long id);

    OppGetDTO updateOppCloseWon(Long id);
}
