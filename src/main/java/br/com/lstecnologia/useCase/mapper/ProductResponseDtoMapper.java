package br.com.lstecnologia.useCase.mapper;

import br.com.lstecnologia.domain.model.ProductModel;
import br.com.lstecnologia.useCase.dto.response.ProductResponseDto;
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
    ProductResponseDto toResponseDto(ProductModel productEntity);

}
