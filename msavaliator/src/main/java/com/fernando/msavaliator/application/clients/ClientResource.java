package com.fernando.msavaliator.application.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "msclients", path = "/clients")
public interface ClientResource {
  
  @GetMapping("/client")
  ResponseEntity<Object> findClientByCpf(@RequestParam("cpf") String cpf);
  
}
