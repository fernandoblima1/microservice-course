package br.com.github.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.github.mscartoes.entities.Cartao;
import br.com.github.mscartoes.repositories.CartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> listarPorRenda(BigDecimal renda) {
        return cartaoRepository.findAllByRenda(renda);
    }
    
}
