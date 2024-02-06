package br.com.lstecnologia.application.useCase;

import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;

/**
 * UseCase interface for creating a new product.
 */
public interface CreateProductUseCase {

    /**
     * Executes the creation of a new product based on the provided request.
     *
     * @param productModelRequest Request containing information for creating the product.
     * @return ProductModelResponse with details of the created product.
     */
    ProductModelResponse execute(ProductModelRequest productModelRequest);

}
