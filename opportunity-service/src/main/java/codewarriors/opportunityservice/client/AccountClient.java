package codewarriors.opportunityservice.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@FeignClient("account-service")
public interface AccountClient {

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountGetDTO getAccountById (@PathVariable long id);
}
