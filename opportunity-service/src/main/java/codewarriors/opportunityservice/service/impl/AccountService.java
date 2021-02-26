package codewarriors.opportunityservice.service.impl;

import codewarriors.opportunityservice.controller.dto.AccountGetDTO;
import codewarriors.opportunityservice.model.Account;
import codewarriors.opportunityservice.repository.AccountRepository;
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
        List<AccountGetDTO> accountsDTO = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();
        for(Account account : accounts) {
            accountsDTO.add(new AccountGetDTO(
                    account.getId(),
                    account.getIndustry(),
                    account.getEmployeeCount(),
                    account.getCity(),
                    account.getCountry()
            ));
        }
        return accountsDTO;
    }

    public AccountGetDTO getAccountById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
          Account account =accountOptional.get();
                return new AccountGetDTO(
                        account.getId(),
                        account.getIndustry(),
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
