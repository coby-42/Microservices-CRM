package com.ironhack.userservice.client;

import com.ironhack.userservice.controller.DTO.LeadGetDTO;
import com.ironhack.userservice.controller.DTO.LeadPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("lead-service")
public interface LeadClient {

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<LeadGetDTO> getLeads();

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public LeadGetDTO postLead(@RequestBody @Valid LeadPostDTO leadPostDTO) ;

    @GetMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO getLead(@PathVariable Long id);

    @PutMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO putLead(@PathVariable Long id, @RequestBody @Valid LeadPostDTO leadPostDTO);

    @DeleteMapping("/lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeadGetDTO deleteLead(@PathVariable Long id);

}
