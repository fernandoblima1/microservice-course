package com.fernando.mscards.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.mscards.application.repositories.CardRepository;import com.fernando.mscards.domain.Card;

import lombok.Data;


@Service
@Data
public class CardsServices {

  private final CardRepository cardRepository;

  public Card save(Card card){
    return cardRepository.save(card);
  }

  public Optional<List<Card>> findByIncome(Long income){
    return cardRepository.findByIncomeLessThanEqual(income);
  }
}
