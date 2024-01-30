package br.com.lstecnologia.useCases.mapper;

import br.com.lstecnologia.entities.model.ProductModel;
import br.com.lstecnologia.useCases.dto.response.ProductResponseDto;
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
