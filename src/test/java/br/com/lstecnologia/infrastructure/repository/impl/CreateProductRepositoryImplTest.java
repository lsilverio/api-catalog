package br.com.lstecnologia.infrastructure.repository.impl;

import br.com.lstecnologia.core.usecase.repository.ExistsByNameProductRepository;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import br.com.lstecnologia.infrastructure.repository.JpaProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
public class CreateProductRepositoryImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private JpaProductRepository productRepository;

    private CreateProductRepositoryImpl createProductRepository;

    private ExistsByNameProductRepository existsByNameProductRepository;

    @Test
    public void testSaveProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("Test Product");
        productEntity.setId(1L);

        when(productRepository.save(productEntity)).thenReturn(productEntity);

        createProductRepository = new CreateProductRepositoryImpl(productRepository);

        ProductEntity savedProduct = createProductRepository.execute(productEntity);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("Test Product", savedProduct.getName());

        verify(productRepository, times(1)).save(productEntity);
    }


    @Test
    public void testExistsByName() {
        when(productRepository.existsByName("ExistingProduct")).thenReturn(true);
        when(productRepository.existsByName("NonExistingProduct")).thenReturn(false);

        createProductRepository = new CreateProductRepositoryImpl(productRepository);
        existsByNameProductRepository = new ExistsByNameProductRepositoryImpl(productRepository);

        assertTrue(existsByNameProductRepository.execute("ExistingProduct"));
        assertFalse(existsByNameProductRepository.execute("NonExistingProduct"));

        verify(productRepository, times(1)).existsByName("ExistingProduct");
        verify(productRepository, times(1)).existsByName("NonExistingProduct");
    }

}
