package com.fernando.mscards.domain;

import java.math.BigDecimal;

import com.fernando.mscards.application.enums.FlagEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="cards_tb")
public class Card {
  
  public Card(String name, FlagEnum flag, BigDecimal income, BigDecimal baseLimit) {
    this.name = name;
    this.flag = flag;
    this.income = income;
    this.baseLimit = baseLimit;
  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Enumerated(EnumType.STRING)
  private FlagEnum flag;
  private BigDecimal income;
  private BigDecimal baseLimit;
}
