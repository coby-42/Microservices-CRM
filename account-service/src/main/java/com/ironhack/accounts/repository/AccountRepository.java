package com.ironhack.accounts.repository;

import com.ironhack.accounts.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
