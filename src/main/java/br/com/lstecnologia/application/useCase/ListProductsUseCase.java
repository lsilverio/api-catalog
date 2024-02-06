package br.com.lstecnologia.application.useCase;

import br.com.lstecnologia.adapter.dto.response.PageableDtoResponse;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import org.springframework.data.domain.Pageable;

/**
 * UseCase interface for listing products.
 */
public interface ListProductsUseCase {

    /**
     * Executes the operation to retrieve a pageable list of products.
     *
     * @param pageable Paging information for the list.
     * @return PageableDtoResponse containing the list of products.
     */
    PageableDtoResponse<ProductModelResponse> execute(Pageable pageable);

}
