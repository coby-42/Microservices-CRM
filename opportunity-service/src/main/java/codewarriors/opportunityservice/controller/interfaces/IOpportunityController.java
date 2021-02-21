package codewarriors.opportunityservice.controller.interfaces;

import codewarriors.opportunityservice.controller.dto.OppGetDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IOpportunityController {

    public OppGetDTO getOppById(@PathVariable long id);
}
