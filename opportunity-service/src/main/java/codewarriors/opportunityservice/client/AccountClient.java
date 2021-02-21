package codewarriors.opportunityservice.client;

import codewarriors.opportunityservice.controller.dto.AccountGetDTO;
import codewarriors.opportunityservice.controller.dto.AccountOppAndContactGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@FeignClient("account-service")
public interface AccountClient {

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountOppAndContactGetDTO getAccountById (@PathVariable long id);
}