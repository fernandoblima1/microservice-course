package br.com.github.msavaliador.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.msavaliador.dtos.SituacaoDTO;
import br.com.github.msavaliador.service.SituacaoService;

@RestController
@RequestMapping("/avaliador")
public class AvaliadorController {
    
  private final AvaliadorService avaliadorService;

  @GetMapping(value = "situacao-cliente", params = "cpf")
  public ResponseEntity<SituacaoDTO> consultaSituacaoCliente(@RequestParam String cpf) {
    SituacaoDTO situacao = avaliadorService.obterSituacaoCliente(cpf);
    return ResponseEntity.ok().build();
  }

}
