package br.com.lstecnologia.useCase.service.exception;

public class ExistsProductByNameException extends RuntimeException {

    public ExistsProductByNameException(String mensagem) {
        super(mensagem);
    }

}
