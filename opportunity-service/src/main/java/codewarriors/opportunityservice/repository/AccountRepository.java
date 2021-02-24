package codewarriors.opportunityservice.repository;

import codewarriors.opportunityservice.model.Account;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
