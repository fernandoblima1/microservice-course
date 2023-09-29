package br.com.github.msavaliador.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.github.msavaliador.dtos.Cartao;
import br.com.github.msavaliador.dtos.CartaoCliente;

@FeignClient(name = "mscartoes", path = "/cartoes")
public interface CartoesClient {

    @GetMapping(value = "/listar", params = "cpf")
    ResponseEntity<List<CartaoCliente>> obterDadosCartao(@RequestParam String cpf);

    @GetMapping(value = "/listar", params = "renda")
    ResponseEntity<List<Cartao>> obterCartoesPorRenda(@RequestParam Long renda);

}
