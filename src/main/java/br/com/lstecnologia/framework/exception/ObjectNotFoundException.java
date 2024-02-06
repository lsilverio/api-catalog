package br.com.lstecnologia.framework.exception;

/**
 * Exception thrown when an expected object is not found.
 */
public class ObjectNotFoundException extends RuntimeException {

    /**
     * Constructs an ObjectNotFoundException with a default message.
     */
    public ObjectNotFoundException() {
        super("Object not found");
    }

    /**
     * Constructs an ObjectNotFoundException with a custom message.
     *
     * @param message The custom error message.
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }

}
