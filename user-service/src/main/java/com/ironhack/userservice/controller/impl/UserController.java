package com.ironhack.userservice.controller.impl;

import com.ironhack.userservice.controller.DTO.AdminGetDTO;
import com.ironhack.userservice.controller.DTO.AdminPostDTO;
import com.ironhack.userservice.controller.DTO.SalesRepGetDTO;
import com.ironhack.userservice.controller.DTO.SalesRepPostDTO;
import com.ironhack.userservice.controller.interfaces.IUserController;
import com.ironhack.userservice.model.Role;
import com.ironhack.userservice.security.CustomUserDetails;
import com.ironhack.userservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class UserController implements IUserController {
    @Autowired
    private IUserService userService;

    @Override
    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminGetDTO createAdmin(@RequestBody @Valid AdminPostDTO adminPostDTO) {
        return userService.createAdmin(adminPostDTO);
    }

    @Override
    @PostMapping("/sales-rep")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRepGetDTO createSalesRep(@RequestBody @Valid SalesRepPostDTO salesRepPostDTO) {
        return userService.createSalesRep(salesRepPostDTO);
    }

    @Override
    @GetMapping("/sales-rep/{id}")
    public SalesRepGetDTO getSalesRepById(@PathVariable Long id) {
        return userService.getSalesRepById(id);
    }

    @Override
    @GetMapping("/roles")
    public Set<Role> getUserRoles(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return userService.getRolesFromPrincipal(customUserDetails);
    }

    @Override
    @GetMapping("/roles/{id}")
    public Set<Role> getUserRolesById(@PathVariable Long id) {
        return userService.getRolesById(id);
    }
}
