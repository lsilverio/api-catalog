package br.com.lstecnologia.application.service.exception;

public class ExistsProductByNameException extends RuntimeException {

    public ExistsProductByNameException(String mensagem) {
        super(mensagem);
    }

}
