package com.fernando.msclients.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.msclients.application.dto.ClientDto;
import com.fernando.msclients.application.services.ClientService;
import com.fernando.msclients.domain.Client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientsController {

  private final ClientService clientService;

  @GetMapping
  public String status() {
    log.info("Obtendo o status do microservice de clients");
    return "ok";
  }

  @PostMapping
  public ResponseEntity<Client> save(@RequestBody ClientDto clientDto) {
    Client client = new Client();
    BeanUtils.copyProperties(clientDto, client);
    return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(client));
  }

  @GetMapping("/client")
  public ResponseEntity<Client> findClientByCpf(@RequestParam("cpf") String cpf) {
    Optional<Client> optionalClient = clientService.findByCpf(cpf);
    if (optionalClient.isPresent()) {
      Client client = new Client();
      BeanUtils.copyProperties(optionalClient.get(), client);
      return ResponseEntity.status(HttpStatus.OK).body(client);
    }
    return ResponseEntity.notFound().build();
  }

  // http://localhost:/PORT:clients?cpf=61108920330
}
