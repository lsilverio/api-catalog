package br.com.lstecnologia.core.usecase;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ProductResponseDto;
import br.com.lstecnologia.core.domain.ProductDomain;
import br.com.lstecnologia.core.exception.ExistsProductByNameException;
import br.com.lstecnologia.core.mapper.ProductMapper;
import br.com.lstecnologia.core.usecase.repository.CreateProductRepository;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CreateProductUseCaseTest {

    public static final String TEST_PRODUCT = "Test Product";
    private CreateProductUseCase createProductUseCase;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private CreateProductRepository createProductRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        createProductUseCase = new CreateProductUseCase(productMapper, createProductRepository);
    }

    @Test
    public void testCreateProduct_Success() {

        ProductRequestDto requestDto = new ProductRequestDto(TEST_PRODUCT);

        ProductDomain productDomain = getProductDomain();
        ProductEntity productEntity = getProductEntity();
        ProductResponseDto productResponseDto = getProductResponseDto();

        when(productMapper.toDomain(requestDto)).thenReturn(productDomain);
        when(productMapper.toEntity(productDomain)).thenReturn(productEntity);
        when(createProductRepository.existsByName(TEST_PRODUCT)).thenReturn(false);
        when(createProductRepository.save(productEntity)).thenReturn(productEntity);
        when(productMapper.toDomain(productEntity)).thenReturn(productDomain);
        when(productMapper.toResponseDto(productDomain)).thenReturn(productResponseDto);

        ProductResponseDto response = createProductUseCase.execute(requestDto);

        assertNotNull(response);
    }

    @Test
    public void testCreateProduct_ExistsProductByNameException() {
        ProductRequestDto requestDto = new ProductRequestDto("Existing Product");

        ProductDomain productDomain = getProductDomain();
        ProductEntity productEntity = getProductEntity();

        when(productMapper.toDomain(requestDto)).thenReturn(productDomain);
        when(productMapper.toEntity(productDomain)).thenReturn(productEntity);
        when(createProductRepository.existsByName(productEntity.getName())).thenReturn(true);

        assertThrows(ExistsProductByNameException.class, () -> createProductUseCase.execute(requestDto));
    }

    private static ProductDomain getProductDomain() {
        ProductDomain productDomain = new ProductDomain();
        productDomain.setName(TEST_PRODUCT);
        productDomain.setId(1L);
        productDomain.setCreationDate(LocalDateTime.now());
        productDomain.setChangeDate(LocalDateTime.now());
        return productDomain;
    }

    private static ProductEntity getProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(TEST_PRODUCT);
        productEntity.setId(1L);
        productEntity.setCreationDate(LocalDateTime.now());
        productEntity.setChangeDate(LocalDateTime.now());
        return productEntity;
    }

    private static ProductResponseDto getProductResponseDto() {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(TEST_PRODUCT);
        productResponseDto.setId(1L);
        productResponseDto.setCreationDate(LocalDateTime.now());
        productResponseDto.setChangeDate(LocalDateTime.now());
        return productResponseDto;
    }

}


