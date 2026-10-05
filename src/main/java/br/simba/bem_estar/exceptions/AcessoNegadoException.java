package br.simba.bem_estar.exceptions;

public class AcessoNegadoException extends RuntimeException{

    public AcessoNegadoException(String mensagem){
        super(mensagem);
    }
    
}
