package com.fernando.mscards.domain;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class ClientCard {
   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cpf;
  private String name;
  @ManyToOne
  @JoinColumn(name = "id_card")
  private Card card;
  private BigDecimal limitFree;

  public ClientCard(String cpf, String name, Card card, BigDecimal limitFree) {
    this.cpf = cpf;
    this.name = name;
    this.card = card;    
    this.limitFree = limitFree;
  }
}
