package br.com.github.msavaliador.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.github.msavaliador.dtos.DadosCliente;

@FeignClient(name = "msclientes", path = "/clientes")
public interface ClienteClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> obterDadosCliente(@RequestParam String cpf);

}
