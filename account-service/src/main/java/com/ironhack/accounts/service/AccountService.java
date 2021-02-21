package com.ironhack.accounts.service;

import com.ironhack.accounts.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
}
