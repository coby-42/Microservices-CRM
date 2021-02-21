package com.ironhack.accounts.controller.impl;

import com.ironhack.accounts.controller.dtos.*;
import com.ironhack.accounts.models.*;
import com.ironhack.accounts.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);

    }

}
