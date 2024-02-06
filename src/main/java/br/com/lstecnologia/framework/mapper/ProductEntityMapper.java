package br.com.lstecnologia.framework.mapper;

import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import br.com.lstecnologia.framework.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between different representations of products.
 */
@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    /**
     * Converts a {@link ProductModelRequest} to a {@link ProductEntity}.
     *
     * @param productModelRequest DTO containing information for creating a product.
     * @return {@link ProductEntity} representing the product.
     */
    ProductEntity toEntity(ProductModelRequest productModelRequest);

    /**
     * Converts a {@link ProductEntity} to a {@link ProductModelResponse}.
     *
     * @param productEntity DTO containing information for creating a product.
     * @return {@link ProductModelResponse} representing the product.
     */
    ProductModelResponse toModelResponse(ProductEntity productEntity);

}
