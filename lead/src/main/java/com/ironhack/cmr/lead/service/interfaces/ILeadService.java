package com.ironhack.cmr.lead.service.interfaces;

import com.ironhack.cmr.lead.dto.LeadGetDTO;
import com.ironhack.cmr.lead.dto.LeadPostDTO;

import java.util.List;

public interface ILeadService {
    List<LeadGetDTO> getLeads();

    LeadGetDTO createLead(LeadPostDTO leadPostDTO);

    LeadGetDTO getLead(Long id);

    LeadGetDTO putLead(Long id, LeadPostDTO leadPostDTO);

    LeadGetDTO deleteLead(Long id);
}
