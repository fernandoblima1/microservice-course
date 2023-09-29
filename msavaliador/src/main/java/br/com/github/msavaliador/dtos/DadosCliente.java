package br.com.github.msavaliador.dtos;

import lombok.Data;

@Data
public class DadosCliente {
  private Long id;
  private String nome;
  private Integer idade;
}
