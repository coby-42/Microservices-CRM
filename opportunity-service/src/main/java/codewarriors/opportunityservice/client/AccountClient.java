package codewarriors.opportunityservice.client;

import codewarriors.opportunityservice.controller.dto.AccountGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("account-service")
public interface AccountClient {

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    AccountGetDTO getAccountById (@PathVariable long id);
}
