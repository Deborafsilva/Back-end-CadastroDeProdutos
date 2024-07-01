package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;


    //Metodo para listas todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    //Método para cadastrar produtos
    public ResponseEntity<?> cadastrar(ProdutoModelo pm){

        //MÉTODO PARA VALIDAR O PRODUTO.
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
            //caso não tenha nome do produto retornará uma mensagem
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
            //caso não tenha nome da marca retornará uma mensagem
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.CREATED);
            //se estiver tudo ok, será salvo
        }
    }
    
}
