package com.ironhack.EdgeBasicAuthHystrix.client;

import com.ironhack.EdgeBasicAuthHystrix.dtos.AccountGetDTO;
import com.ironhack.EdgeBasicAuthHystrix.dtos.AccountOppAndContactGetDTO;
import com.ironhack.EdgeBasicAuthHystrix.dtos.AccountPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("AccountService")
public interface AccountClient {
    /**Get all the accounts	User	GET	/accounts		none	List<AccountGetDTO>
     Get account by ID	User	GET	/account/{id}		none	AccountOppAndContactGetDTO
     Create account	User	POST	/account		AccountPostDTO	AccountPostDTO
     * */

    @GetMapping ("/accounts")
    List<AccountGetDTO> getAccounts();

    @GetMapping ("/account/{id}")
    AccountOppAndContactGetDTO getAccountById(Long id);

    @PostMapping("/account")
    AccountPostDTO createAccount(AccountPostDTO accountPostDTO); //No deberia devolcer un AccountGetDTO???

}
