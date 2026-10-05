package br.simba.bem_estar.rotina;

public class RotinaNaoEncontradaException extends RuntimeException {

    public RotinaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
