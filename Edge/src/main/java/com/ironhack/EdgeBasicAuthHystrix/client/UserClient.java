package com.ironhack.EdgeBasicAuthHystrix.client;

import com.ironhack.EdgeBasicAuthHystrix.dtos.SalesRepGetDTO;
import com.ironhack.EdgeBasicAuthHystrix.dtos.SalesRepPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("UserService")
public interface UserClient {

    @GetMapping("/sales-rep/{id}")
    SalesRepGetDTO getSales(Long id);

    @PostMapping("/sales-rep")
    SalesRepGetDTO createSalesRep(SalesRepPostDTO salesRepPostDTO);

    @GetMapping("/sales-reps/{id}")
    SalesRepGetDTO getSalesRepById(Long id);
}
