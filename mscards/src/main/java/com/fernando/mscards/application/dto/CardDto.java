package com.fernando.mscards.application.dto;

import java.math.BigDecimal;

import com.fernando.mscards.application.enums.FlagEnum;
import com.fernando.mscards.domain.Card;

import lombok.Data;

@Data
public class CardDto {
  private String name;
  private FlagEnum flag;
  private BigDecimal income;
  private BigDecimal baseLimit;

  public Card toModel(){
    return new Card(name, flag, income, baseLimit);
  }
}
