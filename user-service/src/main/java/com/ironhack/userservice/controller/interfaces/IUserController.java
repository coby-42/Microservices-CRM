package com.ironhack.userservice.controller.interfaces;

import com.ironhack.userservice.controller.DTO.AdminGetDTO;
import com.ironhack.userservice.controller.DTO.AdminPostDTO;
import com.ironhack.userservice.controller.DTO.SalesRepGetDTO;
import com.ironhack.userservice.controller.DTO.SalesRepPostDTO;
import com.ironhack.userservice.model.Role;
import com.ironhack.userservice.security.CustomUserDetails;

import java.security.Principal;
import java.util.Set;

public interface IUserController {
    AdminGetDTO createAdmin(AdminPostDTO adminPostDTO);

    SalesRepGetDTO createSalesRep(SalesRepPostDTO salesRepPostDTO);

    SalesRepGetDTO getSalesRepById(Long id);

    Set<Role> getUserRoles(CustomUserDetails customUserDetails);

    Set<Role> getUserRolesById(Long id);
}
