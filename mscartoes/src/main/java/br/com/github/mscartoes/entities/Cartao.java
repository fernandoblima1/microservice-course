package br.com.github.mscartoes.entities;

import java.math.BigDecimal;

import br.com.github.mscartoes.enums.Bandeira;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Enumerated(value = EnumType.STRING)
    private Bandeira bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;
}
