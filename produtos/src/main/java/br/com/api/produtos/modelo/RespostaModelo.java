package br.com.api.produtos.modelo;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

//Classe 'RespostaModelo' será utilizada quando houver algum problema com requisições de cadastramento, seleções, alterações e excluções.
@Component
@Getter
@Setter
public class RespostaModelo {

    private String mensagem;
    
}
