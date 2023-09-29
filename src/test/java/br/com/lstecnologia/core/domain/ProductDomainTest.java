package br.com.lstecnologia.core.domain;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
public class ProductDomainTest {

    @Test
    public void testGettersAndSetters() {
        ProductDomain product = new ProductDomain();

        product.setId(1L);
        product.setName("Produto de Teste");
        product.setChangeDate(LocalDateTime.now());
        product.setCreationDate(LocalDateTime.now());

        assertEquals(1L, product.getId());
        assertEquals("Produto de Teste", product.getName());
        assertNotNull(product.getChangeDate());
        assertNotNull(product.getCreationDate());
    }
}

