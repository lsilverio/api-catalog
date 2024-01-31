package br.com.lstecnologia.useCase.mapper;

import br.com.lstecnologia.useCase.dto.request.ProductRequestDto;
import br.com.lstecnologia.domain.model.ProductModel;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between different representations of products.
 */
@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    /**
     * Converts a ProductRequestDto to a ProductEntity.
     *
     * @param productRequestDto DTO containing information for creating a product.
     * @return Entity representing the product.
     */
    ProductModel toEntity(ProductRequestDto productRequestDto);

}
