package br.com.lstecnologia.application.service;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ProductResponseDto;

public interface CreateProductService {

    ProductResponseDto execute(ProductRequestDto productRequestDto);

}
