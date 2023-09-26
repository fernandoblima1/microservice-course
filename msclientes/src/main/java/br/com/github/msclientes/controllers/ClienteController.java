package br.com.github.msclientes.controllers;

import java.net.URI;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.github.msclientes.dtos.ClienteDTO;
import br.com.github.msclientes.entities.Cliente;
import br.com.github.msclientes.services.ClienteService;
import jakarta.ws.rs.GET;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
  
  private final ClienteService clienteService;

  @PostMapping()
  public ResponseEntity<Object> criarCliente(@RequestBody ClienteDTO clienteDto) {
    var cliente = clienteDto.toModel();
    clienteService.salvar(cliente);
    URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(cliente.getCpf()).toUri();
    return ResponseEntity.created(headerLocation).build();
  }

  @GetMapping
  public ResponseEntity<Cliente> getMethodName(@RequestParam String cpf) {
      var cliente = clienteService.findByCpf(cpf);
      if(cliente.isEmpty()){
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(cliente.get());
  }
  
}
