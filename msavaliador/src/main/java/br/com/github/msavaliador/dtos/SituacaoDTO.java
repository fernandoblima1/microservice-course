package br.com.github.msavaliador.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoDTO {
  private DadosCliente cliente;
  private List<CartaoCliente> cartoes;

}
