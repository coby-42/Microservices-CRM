package codewarriors.opportunityservice.controller.interfaces;
import codewarriors.opportunityservice.controller.dto.AccountGetDTO;

import java.util.*;

public interface AccountControllerInterface {
    List<AccountGetDTO> getAllAccounts();
    AccountGetDTO getAccountById(Long id);
    void createAccount(AccountGetDTO accountGetDTO);
}