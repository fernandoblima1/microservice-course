package br.com.github.msavaliador.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.github.msavaliador.api.CartoesClient;
import br.com.github.msavaliador.api.ClienteClient;
import br.com.github.msavaliador.dtos.Cartao;
import br.com.github.msavaliador.dtos.CartaoAprovado;
import br.com.github.msavaliador.dtos.CartaoCliente;
import br.com.github.msavaliador.dtos.DadosCliente;
import br.com.github.msavaliador.dtos.SituacaoDTO;
import br.com.github.msavaliador.exceptions.AppErrorException;
import br.com.github.msavaliador.exceptions.NotFoundException;
import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorService {
    
    private final ClienteClient clienteClient;
    private final CartoesClient cartoesClient;
    
    public SituacaoDTO obterSituacaoCliente(String cpf) throws NotFoundException, AppErrorException{

        try {
            ResponseEntity<DadosCliente> dadosCliente = clienteClient.obterDadosCliente(cpf);
    
            ResponseEntity<List<CartaoCliente>> cartaoCliente = cartoesClient.obterDadosCartao(cpf);
            
            return SituacaoDTO.builder()
            .cliente(dadosCliente.getBody())
            .cartoes(cartaoCliente.getBody())
            .build();
        } catch (FeignClientException e) {
            int status = e.status();
            if(status == 404)
                throw new NotFoundException("Cliente não encontrado");
            
            throw new AppErrorException(e.getMessage(), status);
        }

        
    }

    public List<CartaoAprovado> avaliarCliente(String cpf, Long renda) throws NotFoundException, AppErrorException{
        

        try {
            ResponseEntity<DadosCliente> dadosCliente = clienteClient.obterDadosCliente(cpf);
            
            List<Cartao> cartoes = cartoesClient.obterCartoesPorRenda(renda).getBody();
            
            List<CartaoAprovado> listaCartoesAprovados = cartoes.stream().map(cartao -> {
                DadosCliente cliente = dadosCliente.getBody();
                
                BigDecimal limiteBasico = cartao.getLimiteBasico();
                BigDecimal idadeBD = BigDecimal.valueOf(cliente.getIdade());
                var fator = idadeBD.divide(BigDecimal.valueOf(10));
                BigDecimal limiteAprovado = fator.multiply(limiteBasico);
                
                CartaoAprovado aprovado = new CartaoAprovado();
                aprovado.setNome(cartao.getNome());
                aprovado.setLimite(limiteAprovado);

                return aprovado;
            }).collect(Collectors.toList());

            return listaCartoesAprovados;
           
        } catch (FeignClientException e) {
            int status = e.status();
            if(status == 404)
                throw new NotFoundException("Cliente não encontrado");
            
            throw new AppErrorException(e.getMessage(), status);
        }
    }
  
}
