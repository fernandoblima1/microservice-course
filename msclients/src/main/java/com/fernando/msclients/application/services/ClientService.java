package com.fernando.msclients.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.msclients.domain.Client;
import com.fernando.msclients.infra.repository.ClientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {

  private final ClientRepository clientRepository;

  @Transactional
  public Client saveClient(Client client) {
    return clientRepository.save(client);
  }

  public Optional<Client> findByCpf(String cpf) {
    return clientRepository.findByCpf(cpf);
  }
}
