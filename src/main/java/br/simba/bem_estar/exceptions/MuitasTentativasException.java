package br.simba.bem_estar.exceptions;

/** Muitas tentativas seguidas (login ou cadastro): o RestExceptionHandler devolve 429. */
public class MuitasTentativasException extends RuntimeException {

    public MuitasTentativasException(String message) {
        super(message);
    }
}
