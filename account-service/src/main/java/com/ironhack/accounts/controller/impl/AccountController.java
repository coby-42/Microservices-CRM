package com.ironhack.accounts.controller.impl;

import com.ironhack.accounts.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
}
