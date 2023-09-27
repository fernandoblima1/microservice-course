package br.com.github.mscartoes.dtos;

import java.math.BigDecimal;

import br.com.github.mscartoes.entities.Cartao;
import br.com.github.mscartoes.enums.Bandeira;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CartaoDTO {
    private String nome;
    @Enumerated(value = EnumType.STRING)
    private Bandeira bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        Cartao cartao = new Cartao();
        cartao.setNome(this.nome);
        cartao.setBandeira(this.bandeira);
        cartao.setRenda(this.renda);
        cartao.setLimiteBasico(this.limite);
        return cartao;
    }
}
