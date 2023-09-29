package br.com.lstecnologia.infrastructure.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductEntityTest {

    @Test
    public void testProductName() {
        ProductEntity product = new ProductEntity();
        product.setName("Test Product");

        CatalogEntity catalog = new CatalogEntity();
        catalog.setProduct(product);
        catalog.setPrice(new BigDecimal("99.99"));
        LocalDateTime startValidityDate = LocalDateTime.of(2023, 9, 28, 12, 0);
        LocalDateTime endValidityDate = LocalDateTime.of(2023, 9, 30, 12, 0);
        catalog.setStartValidityDate(startValidityDate);
        catalog.setEndValidityDate(endValidityDate);

        assertNotNull(catalog.getProduct());

        assertEquals("Test Product", product.getName());
    }
}
