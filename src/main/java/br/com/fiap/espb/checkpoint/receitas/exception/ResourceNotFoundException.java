package br.com.fiap.espb.checkpoint.receitas.exception;

//Tratamento de erro - traz uma mensagem de erro personalizada
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }

}
