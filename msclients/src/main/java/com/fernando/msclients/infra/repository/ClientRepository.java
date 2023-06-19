package com.fernando.msclients.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.msclients.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

  Optional<Client> findByCpf(String cpf);

}
