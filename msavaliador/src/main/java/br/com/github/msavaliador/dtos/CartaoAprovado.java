package br.com.github.msavaliador.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartaoAprovado {
    private String nome;
    private String bandeira;
    private BigDecimal limite;
}
