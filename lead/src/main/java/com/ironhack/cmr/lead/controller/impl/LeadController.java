package com.ironhack.cmr.lead.controller.impl;

import com.ironhack.cmr.lead.dto.LeadGetDTO;
import com.ironhack.cmr.lead.dto.LeadPostDTO;
import com.ironhack.cmr.lead.service.interfaces.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LeadController {
    @Autowired
    ILeadService leadService;

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<LeadGetDTO> getLeads() {
        return leadService.getLeads();
    }

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public LeadGetDTO postLead(@RequestBody @Valid LeadPostDTO leadPostDTO) {
        // TODO: llamada a Users pa comprobar que el sales rep exista
        return leadService.createLead(leadPostDTO);
    }

    @GetMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO getLead(@PathVariable Long id) {
        return leadService.getLead(id);
    }

    @PutMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK) // Quizá deberíamos cambiar los PUT a no content
    public LeadGetDTO putLead(@PathVariable Long id, @RequestBody @Valid LeadPostDTO leadPostDTO) {
        // TODO: llamada a Users pa comprobar que el sales rep exista
        return leadService.putLead(id, leadPostDTO);
    }

    @DeleteMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO deleteLead(@PathVariable Long id) {
        return leadService.deleteLead(id);
    }
}
