package com.fernando.msavaliator.application.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fernando.msavaliator.application.clients.ClientResource;
import com.fernando.msavaliator.application.model.DataClient;
import com.fernando.msavaliator.application.model.SituationClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliatorService {
  
  private final ClientResource clientResource;

  public String findSituationByCpf(String cpf) {
    //obter dados do client pelo msclients 
    //obter cartões do client pelo mscards
    ResponseEntity<Object> response = clientResource.findClientByCpf(cpf);
    return response.getBody().toString();
  }

}
