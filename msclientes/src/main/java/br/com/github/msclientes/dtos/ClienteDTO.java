package br.com.github.msclientes.dtos;

import br.com.github.msclientes.entities.Cliente;
import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
public class ClienteDTO {
  @NonNull
  private String nome;
  @NonNull
  private String cpf;
  @NonNull
  private Integer idade;

  public Cliente toModel() {
    return new Cliente(nome, cpf, idade);
  }
}
