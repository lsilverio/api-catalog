package br.com.lstecnologia.core.exception;

public class ExistsProductByNameException extends RuntimeException {

    public ExistsProductByNameException(String mensagem) {
        super(mensagem);
    }

}
