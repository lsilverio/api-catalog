package br.com.lstecnologia.core.exception;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

public class ExistsProductByNameExceptionTest {

    @Test
    public void testConstructor() {
        String mensagem = "Produto com nome duplicado";
        ExistsProductByNameException exception = new ExistsProductByNameException(mensagem);

        assertEquals(mensagem, exception.getMessage());
    }
}

