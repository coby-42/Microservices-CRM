package com.ironhack.cmr.lead.client;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;

// TODO: confirmar el nombre del servicio cuando lo suban, get a user, decidir si configurar el loadbalancer
@FeignClient("users-service")
@LoadBalancerClient(name = "users-service")
public interface UsersClient {
}
