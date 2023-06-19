package com.fernando.mscards.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.mscards.domain.ClientCard;

public interface ClientRepository extends JpaRepository<ClientCard, Long> {
  Optional<List<ClientCard>> findByCpf(String cpf);
}
