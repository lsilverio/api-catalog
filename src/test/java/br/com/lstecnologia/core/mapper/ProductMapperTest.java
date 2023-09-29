package br.com.lstecnologia.core.mapper;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ProductResponseDto;
import br.com.lstecnologia.core.domain.ProductDomain;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
public class ProductMapperTest {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    public void testToDomainMapping() {
        ProductRequestDto requestDto = new ProductRequestDto("Nome do Produto");

        ProductDomain productDomain = productMapper.toDomain(requestDto);

        assertNotNull(productDomain);
        assertEquals("Nome do Produto", productDomain.getName());
    }

    @Test
    public void testToEntityMapping() {
        ProductDomain productDomain = new ProductDomain();
        productDomain.setName("Nome do Produto");

        ProductEntity productEntity = productMapper.toEntity(productDomain);

        assertNotNull(productEntity);
        assertEquals("Nome do Produto", productEntity.getName());
    }

    @Test
    public void testToResponseDtoMapping() {
        ProductDomain productDomain = new ProductDomain();
        productDomain.setName("Nome do Produto");

        ProductResponseDto responseDto = productMapper.toResponseDto(productDomain);

        assertNotNull(responseDto);
        assertEquals("Nome do Produto", responseDto.getName());
    }

    @Test
    public void testToDomainFromEntityMapping() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("Nome do Produto");

        ProductDomain productDomain = productMapper.toDomain(productEntity);

        assertNotNull(productDomain);
        assertEquals("Nome do Produto", productDomain.getName());
    }


}

