package br.com.lstecnologia.application.service;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;

public interface CreateProductService {

    ProductResponseDto execute(ProductRequestDto productRequestDto);

}
