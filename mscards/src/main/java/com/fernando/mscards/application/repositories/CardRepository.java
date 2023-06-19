package com.fernando.mscards.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.mscards.domain.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

  Optional<List<Card>> findByIncomeLessThanEqual(Long income);
  
}
