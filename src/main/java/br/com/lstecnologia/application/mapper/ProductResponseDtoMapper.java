package br.com.lstecnologia.application.mapper;

import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.domain.entity.ProductEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between different representations of products.
 */
@Mapper(componentModel = "spring")
public interface ProductResponseDtoMapper {

    /**
     * Converts a ProductEntity to a ProductResponseDto.
     *
     * @param productEntity Entity representing a product.
     * @return DTO representing the product in the response.
     */
    ProductResponseDto toResponseDto(ProductEntity productEntity);

}
