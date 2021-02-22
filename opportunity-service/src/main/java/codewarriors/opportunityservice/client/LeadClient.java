package codewarriors.opportunityservice.client;

import codewarriors.opportunityservice.controller.dto.LeadGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("lead-service")
public interface LeadClient {

    @GetMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO getLeadById(@PathVariable Long id);
}
