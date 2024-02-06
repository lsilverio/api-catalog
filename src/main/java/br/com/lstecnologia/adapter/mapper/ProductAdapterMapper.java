package br.com.lstecnologia.adapter.mapper;

import br.com.lstecnologia.adapter.dto.request.ProductDtoRequest;
import br.com.lstecnologia.adapter.dto.response.ProductDtoResponse;
import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between different representations of products.
 */
@Mapper(componentModel = "spring")
public interface ProductAdapterMapper {

    /**
     * Converts a ProductDtoRequest to a ProductModelRequest.
     *
     * @param productDtoRequest DTO containing information for creating a product.
     * @return ProductModelRequest representing the product.
     */
    ProductModelRequest toModelRequest(ProductDtoRequest productDtoRequest);

    /**
     * Converts a ProductModelResponse to a ProductDtoResponse.
     *
     * @param productModelResponse Model representing a product.
     * @return ProductDtoResponse representing the product in the response.
     */
    ProductDtoResponse toDtoResponse(ProductModelResponse productModelResponse);

}
