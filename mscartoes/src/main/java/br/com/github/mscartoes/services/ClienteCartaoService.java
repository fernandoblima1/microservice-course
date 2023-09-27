package br.com.github.mscartoes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.github.mscartoes.entities.ClienteCartao;
import br.com.github.mscartoes.repositories.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listarPorCpf(String cpf) {
        return clienteCartaoRepository.findAllByCpf(cpf);
    }

}
