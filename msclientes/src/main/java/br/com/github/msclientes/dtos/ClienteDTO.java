package br.com.github.msclientes.dtos;

import br.com.github.msclientes.entities.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
  private String nome;
  private String cpf;
  private Integer idade;

  public Cliente toModel() {
    return new Cliente(nome, cpf, idade);
  }
}
