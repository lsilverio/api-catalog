package br.com.lstecnologia.adapter.repository;

import br.com.lstecnologia.adapter.repository.impl.ProductRepositoryImpl;
import br.com.lstecnologia.domain.model.ProductModel;
import br.com.lstecnologia.framework.persistence.JpaProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the ProductRepositoryImpl class.
 */
class ProductRepositoryImplTest {

    @Mock
    private JpaProductRepository productRepository;

    @InjectMocks
    private ProductRepositoryImpl productRepositoryImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test the findById method to find a product by ID.
     * Should return an Optional containing the found product.
     */
    @Test
    void shouldFindProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(new ProductModel()));

        Optional<ProductModel> result = productRepositoryImpl.findById(1L);

        assertTrue(result.isPresent());
    }

    /**
     * Test the findById method for a non-existing product.
     * Should return an empty Optional.
     */
    @Test
    void shouldReturnEmptyOptionalForNonExistingProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<ProductModel> result = productRepositoryImpl.findById(1L);

        assertTrue(result.isEmpty());
    }

    /**
     * Test the findAll method to find all products.
     * Should return an iterable containing at least one product.
     */
    @Test
    void shouldFindAllProducts() {
        when(productRepository.findAll()).thenReturn(Collections.singletonList(new ProductModel()));

        Iterable<ProductModel> result = productRepositoryImpl.findAll();

        assertNotNull(result);
        assertTrue(result.iterator().hasNext());
    }

    /**
     * Test the findAll method with pagination.
     * Should return a Page containing at least one product.
     */
    @Test
    void shouldFindAllProductsPageable() {
        when(productRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.singletonList(new ProductModel())));

        Page<ProductModel> result = productRepositoryImpl.findAll(Pageable.unpaged());

        assertNotNull(result);
        assertTrue(result.hasContent());
    }

    /**
     * Test the save method to save a product.
     * Should return the saved product.
     */
    @Test
    void shouldSaveProduct() {
        when(productRepository.save(any())).thenReturn(new ProductModel());

        ProductModel result = productRepositoryImpl.save(new ProductModel());

        assertNotNull(result);
    }

    /**
     * Test the deleteById method to delete a product by ID.
     * Should not throw any exception.
     */
    @Test
    void shouldDeleteProductById() {
        doNothing().when(productRepository).deleteById(1L);

        assertDoesNotThrow(() -> productRepositoryImpl.deleteById(1L));
    }

    /**
     * Test the existsByName method to check if a product exists by name.
     * Should return true.
     */
    @Test
    void shouldCheckIfProductExistsByName() {
        when(productRepository.existsByName("Test Product")).thenReturn(true);

        boolean result = productRepositoryImpl.existsByName("Test Product");

        assertTrue(result);
    }
}
