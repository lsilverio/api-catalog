package br.com.lstecnologia.useCases.mapper;

import br.com.lstecnologia.useCases.dto.request.ProductRequestDto;
import br.com.lstecnologia.entities.model.ProductModel;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between different representations of products.
 */
@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    /**
     * Converts a ProductRequestDto to a ProductEntity.
     *
     * @param productRequestDto DTO containing information for creating a product.
     * @return Entity representing the product.
     */
    ProductModel toEntity(ProductRequestDto productRequestDto);

}
