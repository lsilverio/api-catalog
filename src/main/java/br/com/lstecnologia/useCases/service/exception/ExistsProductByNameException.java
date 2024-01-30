package br.com.lstecnologia.useCases.service.exception;

public class ExistsProductByNameException extends RuntimeException {

    public ExistsProductByNameException(String mensagem) {
        super(mensagem);
    }

}
