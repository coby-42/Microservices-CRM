package com.ironhack.userservice.service.impl;

import com.ironhack.userservice.controller.DTO.AdminGetDTO;
import com.ironhack.userservice.controller.DTO.AdminPostDTO;
import com.ironhack.userservice.controller.DTO.SalesRepGetDTO;
import com.ironhack.userservice.controller.DTO.SalesRepPostDTO;
import com.ironhack.userservice.model.Admin;
import com.ironhack.userservice.model.Role;
import com.ironhack.userservice.model.SalesRep;
import com.ironhack.userservice.model.User;
import com.ironhack.userservice.repository.AdminRepository;
import com.ironhack.userservice.repository.RoleRepository;
import com.ironhack.userservice.repository.SalesRepRepository;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.security.CustomUserDetails;
import com.ironhack.userservice.service.interfaces.IUserService;
import com.ironhack.userservice.utils.PasswordUtil;
import com.ironhack.userservice.utils.styles.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;


    @Override
    public AdminGetDTO createAdmin(AdminPostDTO adminPostDTO) {
        //Check if username is not already taken
        Optional<User> user = userRepository.findUserByUsername(adminPostDTO.getUsername());
        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        try {
            Admin admin = adminRepository.save(
                    new Admin(adminPostDTO.getUsername(),
                            PasswordUtil.encryptPassword(adminPostDTO.getPassword()))
            );
            roleRepository.save(new Role("ADMIN", admin));
            return AdminToGetDTO(admin);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong body, doesn't match proper AdminPostDTO");
        }
    }

    @Override
    public SalesRepGetDTO createSalesRep(SalesRepPostDTO salesRepPostDTO) {
        //Check if username is not already taken
        Optional<User> user = userRepository.findUserByUsername(salesRepPostDTO.getUsername());
        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        try {
            SalesRep salesRep = salesRepRepository.save(new SalesRep(
                    salesRepPostDTO.getUsername(),
                    PasswordUtil.encryptPassword(salesRepPostDTO.getPassword()),
                    salesRepPostDTO.getFirstName(),
                    salesRepPostDTO.getLastName()
            ));
            roleRepository.save(new Role("SALES_REP", salesRep));
            return SalesRepToGetDTO(salesRep);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong body, doesn't match proper SalesRepPostDTO");
        }
    }

    @Override
    public SalesRepGetDTO getSalesRepById(Long id) {
        Optional<SalesRep> salesRepOptional = salesRepRepository.findById(id);
        if (salesRepOptional.isPresent())
            return SalesRepToGetDTO(salesRepOptional.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No SalesRep for that ID");
    }

    @Override
    public Set<Role> getRolesFromPrincipal(CustomUserDetails customUserDetails) {
        Optional<User> userOptional = userRepository.findUserByUsername(customUserDetails.getUsername());
        if (userOptional.isPresent())
            return userOptional.get().getRoles();
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't get roles for logged in user");
    }

    @Override
    public Set<Role> getRolesById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
            return userOptional.get().getRoles();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No User for that ID");
    }

    @Override
    public void createAdminIfNecessary() {
        List<Admin> adminList = adminRepository.findAll();
        if (adminList.size() < 1) {
            Admin admin = adminRepository.save(new Admin("admin", PasswordUtil.encryptPassword("123456")));
            roleRepository.save(new Role("ADMIN", admin));
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\n\tAdmin created!!");
        } else {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\n\tAdmin already exists in Database");
        }
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT);
    }

    @Override
    public void deleteSalesRep(Long id) {
        Optional<SalesRep> salesRepOptional = salesRepRepository.findById(id);
        if (salesRepOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Sales Rep with that ID");

        try {
            salesRepRepository.delete(salesRepOptional.get());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't delete the Sales Rep");
        }
    }

    private AdminGetDTO AdminToGetDTO(Admin admin) {
        return new AdminGetDTO(
                admin.getId(),
                admin.getUsername(),
                admin.getRoles()
        );
    }

    private SalesRepGetDTO SalesRepToGetDTO(SalesRep salesRep) {
        Set<String> roles = new HashSet<>();
        for (Role role : salesRep.getRoles()) {
            roles.add(role.getName());
        }
        return new SalesRepGetDTO(
                salesRep.getId(),
                salesRep.getUsername(),
                salesRep.getFirstName(),
                salesRep.getLastName(),
                roles);
    }
}
