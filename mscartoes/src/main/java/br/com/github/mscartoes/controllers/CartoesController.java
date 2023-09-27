package br.com.github.mscartoes.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.mscartoes.dtos.CartaoDTO;
import br.com.github.mscartoes.entities.Cartao;
import br.com.github.mscartoes.entities.ClienteCartao;
import br.com.github.mscartoes.response.ClienteCartaoResponse;
import br.com.github.mscartoes.services.CartaoService;
import br.com.github.mscartoes.services.ClienteCartaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesController {
    
    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody CartaoDTO cartao) {
        
        System.out.println(cartaoService.salvar(cartao.toModel()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/listar", params = "renda")
    public ResponseEntity<List<Cartao>> listarPorRenda(@RequestParam Long renda) {
        List<Cartao> cartoes = cartaoService.listarPorRenda(BigDecimal.valueOf(renda));
        return ResponseEntity.ok(cartoes);
    }

    @GetMapping(value = "/listar", params = "cpf")
    public ResponseEntity<List<ClienteCartaoResponse>> listarPorCliente(@RequestParam String cpf) {
        List<ClienteCartao> cartoes = clienteCartaoService.listarPorCpf(cpf);
        List<ClienteCartaoResponse> response = cartoes.stream().map(ClienteCartaoResponse::fromModel).collect(Collectors.toList()) ;
        return ResponseEntity.ok(response);
    }

}
