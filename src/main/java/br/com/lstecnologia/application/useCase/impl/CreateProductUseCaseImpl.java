package br.com.lstecnologia.application.useCase.impl;

import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import br.com.lstecnologia.application.gateway.ProductGateway;
import br.com.lstecnologia.application.useCase.CreateProductUseCase;
import br.com.lstecnologia.application.useCase.exception.ExistsProductByNameException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductGateway productGateway;

    /**
     * Executes the creation of a new product based on the provided request.
     *
     * @param productModelRequest Request containing information for creating the product.
     * @return ProductModelResponse with details of the created product.
     * @throws ExistsProductByNameException if a product with the same name already exists.
     */
    @Override
    public ProductModelResponse execute(@Valid ProductModelRequest productModelRequest) {

        if (productGateway.existsByName(productModelRequest.name())) {
            throw new ExistsProductByNameException();
        }

        return productGateway.save(productModelRequest);
    }

}
