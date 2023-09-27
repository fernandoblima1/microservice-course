package br.com.github.mscartoes.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.github.mscartoes.entities.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    @Query("SELECT c FROM Cartao c WHERE c.renda <= :renda")
    List<Cartao> findAllByRenda(BigDecimal renda);
    
}
