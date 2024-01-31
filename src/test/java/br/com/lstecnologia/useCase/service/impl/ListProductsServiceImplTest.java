package br.com.lstecnologia.useCase.service.impl;

import br.com.lstecnologia.useCase.dto.response.PageableResponseDto;
import br.com.lstecnologia.useCase.dto.response.ProductResponseDto;
import br.com.lstecnologia.useCase.mapper.ProductResponseDtoMapper;
import br.com.lstecnologia.domain.model.ProductModel;
import br.com.lstecnologia.adapter.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the ListProductsServiceImpl class.
 */
class ListProductsServiceImplTest {

    @Mock
    private ProductResponseDtoMapper productResponseDtoMapper;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ListProductsServiceImpl listProductsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Verifies that ListProductsServiceImpl executes the list products operation successfully.
     */
    @Test
    void shouldExecuteListProductsSuccessfully() {
        ProductModel productEntity = new ProductModel();
        productEntity.setId(1L);
        productEntity.setName("Test Product");

        List<ProductModel> productEntityList = Collections.singletonList(productEntity);

        Pageable pageable = Pageable.unpaged();
        Page<ProductModel> productEntityPage = new PageImpl<>(productEntityList, pageable, 1);

        when(productRepository.findAll(pageable)).thenReturn(productEntityPage);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(1L);
        productResponseDto.setName("Test Product");

        when(productResponseDtoMapper.toResponseDto(productEntity)).thenReturn(productResponseDto);

        PageableResponseDto<ProductResponseDto> result = listProductsService.execute(pageable);

        assertEquals(1, result.getTotalElements());
    }
}
