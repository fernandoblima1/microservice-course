package com.fernando.msavaliator.application.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CardClient {
  private String name;
  private String flag;
  private BigDecimal limitFree;
}
