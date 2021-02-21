package com.ironhack.EdgeBasicAuthHystrix.client;

import com.ironhack.EdgeBasicAuthHystrix.dtos.OppGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("OpportunityService")
public interface OpportunityClient {

    @GetMapping ("/opportunity/{id}")
    OppGetDTO getOpportunityById(Long id);

    @PostMapping ("/opportunity/{lead-id}")
    OppGetDTO createOpportunityFromLeadUser(Long leadId);

    @PutMapping ("/opportunity/close-lost/{id}")
    OppGetDTO closeLostOpportunityById(Long id);

    @PutMapping ("/opportunity/close-won/{id}")
    OppGetDTO closeWonOpportunityById(Long id);
}
