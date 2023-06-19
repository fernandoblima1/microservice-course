package com.fernando.mscards.application.dto;

import java.math.BigDecimal;

import com.fernando.mscards.domain.ClientCard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardByClient {
  private String name;
  private String flag;
  private BigDecimal limitFree;

  public static CardByClient fromModel(ClientCard model){
    return new CardByClient(
      model.getCard().getName(),
      model.getCard().getFlag().toString(),
      model.getLimitFree()
    );
  }
}
