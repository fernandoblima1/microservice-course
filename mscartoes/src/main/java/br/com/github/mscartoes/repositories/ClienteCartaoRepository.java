package br.com.github.mscartoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.github.mscartoes.entities.ClienteCartao;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
    
    @Query("SELECT c FROM ClienteCartao c WHERE c.cpf = :cpf")
    List<ClienteCartao> findAllByCpf(String cpf);

}
