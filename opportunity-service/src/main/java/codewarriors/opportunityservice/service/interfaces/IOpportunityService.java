package codewarriors.opportunityservice.service.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;
import codewarriors.opportunityservice.controller.dto.OppPostDTO;

public interface IOpportunityService {

    public OppGetDTO createOpp (long id, OppPostDTO oppPostDTO);

    public OppGetDTO updateOppCloseLost(long id);

    public OppGetDTO updateOppCloseWon (long id);
}
