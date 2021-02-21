package com.ironhack.EdgeBasicAuthHystrix.client;

import com.ironhack.EdgeBasicAuthHystrix.dtos.LeadGetDTO;
import com.ironhack.EdgeBasicAuthHystrix.dtos.LeadPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient("LeadService")
public interface LeadClient {

    @GetMapping("/leads")
    List<LeadGetDTO> getLeads();

    @PostMapping("/lead")
    LeadGetDTO createLead(LeadPostDTO lead);

    @GetMapping("/lead/{id}")
    LeadGetDTO getLeadById(Long id);

    @PutMapping("/lead/{id}")
    LeadGetDTO updateLeadById(LeadPostDTO lead);
}
