package com.ironhack.userservice.service.interfaces;

import com.ironhack.userservice.controller.DTO.AdminGetDTO;
import com.ironhack.userservice.controller.DTO.AdminPostDTO;
import com.ironhack.userservice.controller.DTO.SalesRepGetDTO;
import com.ironhack.userservice.controller.DTO.SalesRepPostDTO;
import com.ironhack.userservice.model.Role;
import com.ironhack.userservice.security.CustomUserDetails;

import java.util.Set;

public interface IUserService {
    AdminGetDTO createAdmin(AdminPostDTO adminPostDTO);

    SalesRepGetDTO createSalesRep(SalesRepPostDTO salesRepPostDTO);

    SalesRepGetDTO getSalesRepById(Long id);

    Set<Role> getRolesFromPrincipal(CustomUserDetails customUserDetails);

    Set<Role> getRolesById(Long id);

    void createAdminIfNecessary();

    void deleteSalesRep(Long id);
}
