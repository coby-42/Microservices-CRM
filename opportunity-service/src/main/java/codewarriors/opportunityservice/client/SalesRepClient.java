package codewarriors.opportunityservice.client;

import codewarriors.opportunityservice.controller.dto.LeadGetDTO;
import codewarriors.opportunityservice.controller.dto.SalesRepGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("salesRep-service")
public interface SalesRepClient {

    @GetMapping("/sales-rep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRepGetDTO getSalesRepById(@PathVariable long id);
}
