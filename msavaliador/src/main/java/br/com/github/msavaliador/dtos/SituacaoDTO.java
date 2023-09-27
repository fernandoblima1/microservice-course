package br.com.github.msavaliador.dtos;

import java.util.List;

import lombok.Data;

@Data
public class SituacaoDTO {
  private DadosCliente cliente;
  private List<CartaoCliente> cartoes;
}
