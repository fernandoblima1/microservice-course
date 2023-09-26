package br.com.github.msclientes.services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.github.msclientes.entities.Cliente;
import br.com.github.msclientes.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
  
  private final ClienteRepository clienteRepository;

  @Transactional
  public Cliente salvar(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public Optional<Cliente> findByCpf(String cpf) {
    return clienteRepository.findByCpf(cpf);
  }
}
