package com.fernando.msavaliator.application.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SituationClient {
  private DataClient dataClient;
  private List<CardClient> cards;
}
