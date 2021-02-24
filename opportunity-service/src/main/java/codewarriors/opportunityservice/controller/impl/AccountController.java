package codewarriors.opportunityservice.controller.impl;

import codewarriors.opportunityservice.controller.dto.AccountGetDTO;
import codewarriors.opportunityservice.controller.interfaces.AccountControllerInterface;
import codewarriors.opportunityservice.service.impl.AccountService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountGetDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountGetDTO getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountGetDTO accountGetDTO) {
        accountService.createAccount(accountGetDTO);

    }

}
