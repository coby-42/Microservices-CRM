package com.ironhack.accounts.service;

import com.ironhack.accounts.controller.dtos.*;
import com.ironhack.accounts.models.*;
import com.ironhack.accounts.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

import java.util.*;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        if (accountRepository.findById(id).isPresent()) {
            return accountRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The account with id " + id + "doesn't exist in the database");
        }
    }

    public void createAccount(AccountDTO accountDTO) {

        accountRepository.save(new Account(
                accountDTO.getIndustry(),
                accountDTO.getEmployeeCount(),
                accountDTO.getCity(),
                accountDTO.getCountry()
        ));

    }
}
