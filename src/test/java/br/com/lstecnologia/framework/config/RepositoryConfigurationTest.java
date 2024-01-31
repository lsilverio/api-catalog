package br.com.lstecnologia.framework.config;

import br.com.lstecnologia.adapter.repository.ProductRepository;
import br.com.lstecnologia.adapter.repository.impl.ProductRepositoryImpl;
import br.com.lstecnologia.framework.persistence.JpaProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the RepositoryConfiguration class.
 */
class RepositoryConfigurationTest {

    /**
     * Verifies that the RepositoryConfiguration class creates a ProductRepository bean.
     */
    @Test
    void shouldCreateProductRepositoryBean() {
        JpaProductRepository jpaProductRepository = Mockito.mock(JpaProductRepository.class);
        RepositoryConfiguration repositoryConfiguration = new RepositoryConfiguration();

        ProductRepository productRepository = repositoryConfiguration.productRepository(jpaProductRepository);

        assertNotNull(productRepository);
        assertTrue(productRepository instanceof ProductRepositoryImpl);
    }
}
