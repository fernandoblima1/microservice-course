package br.com.github.msavaliador.dtos;

import lombok.Data;

@Data
public class CartaoCliente {
  private String nome;
  private String bandeira;
  private String limiteLiberado;
}
