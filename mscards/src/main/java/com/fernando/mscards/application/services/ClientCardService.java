package com.fernando.mscards.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.mscards.application.repositories.ClientRepository;
import com.fernando.mscards.domain.ClientCard;

import lombok.Data;

@Service
@Data
public class ClientCardService {
  private final ClientRepository clientRepository;

  public Optional<List<ClientCard>> listByCpf(String cpf){
    return clientRepository.findByCpf(cpf);
  }
}
