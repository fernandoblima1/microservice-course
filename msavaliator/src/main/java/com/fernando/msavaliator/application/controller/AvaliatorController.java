package com.fernando.msavaliator.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.msavaliator.application.model.SituationClient;
import com.fernando.msavaliator.application.services.AvaliatorService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/avaliacao")
public class AvaliatorController {
  
  private final AvaliatorService avaliatorService;

  @GetMapping
  public String hello() {
      return "Ola";
  }
  
  @GetMapping("/situation")
  public ResponseEntity<String> consultSituationClient(@RequestParam String cpf){
    String situationClient = avaliatorService.findSituationByCpf(cpf);
    return ResponseEntity.ok().body(situationClient);
  }

}
