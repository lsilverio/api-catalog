package br.com.lstecnologia.useCases.service;

import br.com.lstecnologia.useCases.dto.request.ProductRequestDto;
import br.com.lstecnologia.useCases.dto.response.ProductResponseDto;

public interface CreateProductService {

    /**
     * Executes the creation of a new product based on the provided request.
     *
     * @param productRequestDto Request containing information for creating the product.
     * @return Response with details of the created product.
     */
    ProductResponseDto execute(ProductRequestDto productRequestDto);

}
