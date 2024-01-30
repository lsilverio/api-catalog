package br.com.lstecnologia.application.mapper;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.domain.entity.ProductEntity;
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
    ProductEntity toEntity(ProductRequestDto productRequestDto);

}
