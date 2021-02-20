package com.ironhack.cmr.lead.service.impl;

import com.ironhack.cmr.lead.dto.LeadGetDTO;
import com.ironhack.cmr.lead.dto.LeadPostDTO;
import com.ironhack.cmr.lead.model.Lead;
import com.ironhack.cmr.lead.repository.LeadRepository;
import com.ironhack.cmr.lead.service.interfaces.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeadService implements ILeadService {
    @Autowired
    LeadRepository leadRepository;

    @Override
    public List<LeadGetDTO> getLeads() {
        return leadRepository.findAll()
                .stream()
                .map(LeadGetDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public LeadGetDTO createLead(LeadPostDTO leadPostDTO) {
        Lead lead = new Lead(leadPostDTO);
        return new LeadGetDTO(leadRepository.save(lead));
    }

    @Override
    public LeadGetDTO getLead(Integer id) {
        return new LeadGetDTO(findLead(id));
    }

    @Override
    public LeadGetDTO putLead(Integer id, LeadPostDTO leadPostDTO) {
        findLead(id);
        Lead lead = new Lead(id, leadPostDTO);
        return new LeadGetDTO(leadRepository.save(lead));
    }

    @Override
    public LeadGetDTO deleteLead(Integer id) {
        Lead optionalLead = findLead(id);
        leadRepository.delete(optionalLead);
        return new LeadGetDTO(optionalLead);
    }

    private Lead findLead(Integer id) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found for id = " + id);
        return optionalLead.get();
    }
}
