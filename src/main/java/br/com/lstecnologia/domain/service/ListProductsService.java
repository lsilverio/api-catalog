package br.com.lstecnologia.domain.service;

import br.com.lstecnologia.application.dto.response.PageableResponseDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for listing products.
 */
public interface ListProductsService {

    /**
     * Executes the operation to retrieve a pageable list of products.
     *
     * @param pageable Paging information for the list.
     * @return PageableResponseDto containing the list of products.
     */
    PageableResponseDto<ProductResponseDto> execute(Pageable pageable);

}
