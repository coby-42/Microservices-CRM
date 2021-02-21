package com.ironhack.accounts.controller.interfaces;

import com.ironhack.accounts.controller.dtos.*;
import com.ironhack.accounts.models.*;

import java.util.*;

public interface AccountControllerInterface {
    List<AccountGetDTO> getAllAccounts();
    public AccountGetDTO getAccountById(Long id);
    public void createAccount(AccountGetDTO accountGetDTO);
}