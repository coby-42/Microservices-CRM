package com.ironhack.accounts.controller.interfaces;

import com.ironhack.accounts.controller.dtos.*;
import com.ironhack.accounts.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface AccountControllerInterface {
    List<Account> getAllAccounts();
    public Account getAccountById(Long id);
    public void createAccount(AccountDTO accountDTO);
}