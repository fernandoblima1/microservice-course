package br.com.github.mscartoes.response;

import java.math.BigDecimal;

import br.com.github.mscartoes.entities.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCartaoResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;


    public static ClienteCartaoResponse fromModel(ClienteCartao model){
       return new ClienteCartaoResponse(
        model.getCartao().getNome(),
        model.getCartao().getBandeira().toString(),
        model.getLimite()
       );
    }
}
