package br.com.github.msclientes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.github.msclientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

  @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
  Optional<Cliente> findByCpf(String cpf);
  
}
