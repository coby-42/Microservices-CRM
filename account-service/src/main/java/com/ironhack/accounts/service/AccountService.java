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

    public List<AccountGetDTO> getAllAccounts() {
        List<AccountGetDTO> accounts = new ArrayList<>();
        for(Account account : accountRepository.findAll()) {
            accounts.add(new AccountGetDTO(
                    account.getId(),
                    account.getIndustry().toString(),
                    account.getEmployeeCount(),
                    account.getCity(),
                    account.getCountry()
            ));

        }
        return accounts;
    }

    public AccountGetDTO getAccountById(Long id) {
        if (accountRepository.findById(id).isPresent()) {
          Account account = accountRepository.findById(id).get();
                return new AccountGetDTO(
                        account.getId(),
                        account.getIndustry().toString(),
                        account.getEmployeeCount(),
                        account.getCity(),
                        account.getCountry()
                );

            } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The account with id " + id + "doesn't exist in the database");
        }
    }

    public void createAccount(AccountGetDTO accountGetDTO) {

        accountRepository.save(new Account(
                accountGetDTO.getIndustry(),
                accountGetDTO.getEmployeeCount(),
                accountGetDTO.getCity(),
                accountGetDTO.getCountry()
        ));

    }
}
