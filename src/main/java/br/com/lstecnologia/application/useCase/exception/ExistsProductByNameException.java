package br.com.lstecnologia.application.useCase.exception;

/**
 * Exception thrown when a product with the same name already exists.
 */
public class ExistsProductByNameException extends RuntimeException {

    /**
     * Constructs an {@code ExistsProductByNameException} with the default message.
     */
    public ExistsProductByNameException() {
        super("Exists product by name");
    }

    /**
     * Constructs an {@code ExistsProductByNameException} with the specified message.
     *
     * @param mensagem The detail message.
     */
    public ExistsProductByNameException(String mensagem) {
        super(mensagem);
    }

}
