package br.com.lstecnologia.useCases.service.impl;

import br.com.lstecnologia.adapters.repository.ProductRepository;
import br.com.lstecnologia.entities.model.ProductModel;
import br.com.lstecnologia.useCases.dto.request.ProductRequestDto;
import br.com.lstecnologia.useCases.dto.response.ProductResponseDto;
import br.com.lstecnologia.useCases.mapper.ProductEntityMapper;
import br.com.lstecnologia.useCases.mapper.ProductResponseDtoMapper;
import br.com.lstecnologia.useCases.service.exception.ExistsProductByNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the CreateProductServiceImpl class.
 */
class CreateProductServiceImplTest {

    @Mock
    private ProductResponseDtoMapper productResponseDtoMapper;

    @Mock
    private ProductEntityMapper productEntityMapper;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateProductServiceImpl createProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Verifies that the CreateProductServiceImpl class creates a product successfully.
     */
    @Test
    void shouldExecuteCreateProductSuccessfully() {
        ProductRequestDto productRequestDto = new ProductRequestDto("Test Product");

        when(productRepository.existsByName("Test Product")).thenReturn(false);
        when(productEntityMapper.toEntity(productRequestDto)).thenReturn(new ProductModel());
        when(productRepository.save(any())).thenReturn(new ProductModel());
        when(productResponseDtoMapper.toResponseDto(any())).thenReturn(new ProductResponseDto());

        assertDoesNotThrow(() -> createProductService.execute(productRequestDto));
    }

    /**
     * Verifies that the CreateProductServiceImpl class throws ExistsProductByNameException when a product with the same name already exists.
     */
    @Test
    void shouldThrowExistsProductByNameException() {
        ProductRequestDto productRequestDto = new ProductRequestDto("Test Product");

        when(productRepository.existsByName("Test Product")).thenReturn(true);

        assertThrows(ExistsProductByNameException.class, () -> createProductService.execute(productRequestDto));
    }
}
