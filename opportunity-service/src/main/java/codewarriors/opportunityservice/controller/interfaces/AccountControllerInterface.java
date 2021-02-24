package codewarriors.opportunityservice.controller.interfaces;
import codewarriors.opportunityservice.controller.dto.AccountGetDTO;

import java.util.*;

public interface AccountControllerInterface {
    List<AccountGetDTO> getAllAccounts();
    public AccountGetDTO getAccountById(Long id);
    public void createAccount(AccountGetDTO accountGetDTO);
}