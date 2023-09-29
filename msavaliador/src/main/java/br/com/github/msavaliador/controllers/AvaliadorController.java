package br.com.github.msavaliador.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.msavaliador.dtos.CartaoAprovado;
import br.com.github.msavaliador.dtos.DadosAvaliacaoDTO;
import br.com.github.msavaliador.dtos.SituacaoDTO;
import br.com.github.msavaliador.exceptions.AppErrorException;
import br.com.github.msavaliador.exceptions.NotFoundException;
import br.com.github.msavaliador.service.AvaliadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/avaliador")
@RequiredArgsConstructor
public class AvaliadorController {
    
  private final AvaliadorService avaliadorService;

  @GetMapping(value = "/situacao-cliente", params = "cpf")
  public ResponseEntity<Object> consultaSituacaoCliente(@RequestParam String cpf) throws AppErrorException, NotFoundException {
    try{
      SituacaoDTO situacao = avaliadorService.obterSituacaoCliente(cpf);
      return ResponseEntity.ok(situacao);
    } catch (NotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (AppErrorException e) {
      return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
    }
  }

  @PostMapping(value = "/avaliacao")
  public ResponseEntity<Object> avaliarCliente(@RequestBody DadosAvaliacaoDTO dadosAvaliacaoDTO) {
     try{
      List<CartaoAprovado> avaliacao = avaliadorService.avaliarCliente(dadosAvaliacaoDTO.getCpf(), dadosAvaliacaoDTO.getRenda());
      return ResponseEntity.ok(avaliacao);
    } catch (NotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (AppErrorException e) {
      return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
    }
  }

}
