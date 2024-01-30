package br.com.lstecnologia.application.service;

import br.com.lstecnologia.application.dto.response.PageableResponseDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.mapper.ProductResponseDtoMapper;
import br.com.lstecnologia.application.service.impl.ListProductsServiceImpl;
import br.com.lstecnologia.domain.entity.ProductEntity;
import br.com.lstecnologia.framework.persistence.ProductRepository;
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

    @Test
    void shouldExecuteListProductsSuccessfully() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("Test Product");

        List<ProductEntity> productEntityList = Collections.singletonList(productEntity);

        Pageable pageable = Pageable.unpaged();
        Page<ProductEntity> productEntityPage = new PageImpl<>(productEntityList, pageable, 1);

        when(productRepository.findAll(pageable)).thenReturn(productEntityPage);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(1L);
        productResponseDto.setName("Test Product");

        when(productResponseDtoMapper.toResponseDto(productEntity)).thenReturn(productResponseDto);

        PageableResponseDto<ProductResponseDto> result = listProductsService.execute(pageable);

        assertEquals(1, result.getTotalElements());
    }

}
