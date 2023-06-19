package com.fernando.mscards.application.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.mscards.application.dto.CardByClient;
import com.fernando.mscards.application.dto.CardDto;
import com.fernando.mscards.application.services.CardsServices;
import com.fernando.mscards.application.services.ClientCardService;
import com.fernando.mscards.domain.Card;
import com.fernando.mscards.domain.ClientCard;

import lombok.Data;

@RestController
@RequestMapping("/cards")
@Data
public class CardsController {

  private final CardsServices cardsService;
  private final ClientCardService clientCardService;

  @GetMapping
  public String hello(){
    return "olá!";
  }

  @PostMapping("/new")
  public ResponseEntity<Card> save(@RequestBody CardDto cardDto){
    Card card = cardDto.toModel();
    return ResponseEntity.status(HttpStatus.CREATED).body(cardsService.save(card));
  }

  @GetMapping("/all")
  public ResponseEntity<Object> getCardByIncome(@RequestParam Long income){
    Optional<List<Card>> optionalList = cardsService.findByIncome(income);
    if(optionalList.get().isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cards not found.");
    } 
    List<Card> cardList = optionalList.get();
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardList);
  }

  @GetMapping("/client")
  public ResponseEntity<Object> getCardsByClient(@RequestParam String cpf){
    Optional<List<ClientCard>> optionalList = clientCardService.listByCpf(cpf);
    if(optionalList.get().isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cards not found.");
    } 
    List<CardByClient> cardList = optionalList.get().stream().map(CardByClient::fromModel).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardList);
  }
}
