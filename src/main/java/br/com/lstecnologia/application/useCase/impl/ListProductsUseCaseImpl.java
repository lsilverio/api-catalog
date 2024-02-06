package br.com.lstecnologia.application.useCase.impl;

import br.com.lstecnologia.adapter.dto.response.PageableDtoResponse;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import br.com.lstecnologia.application.gateway.ProductGateway;
import br.com.lstecnologia.application.useCase.ListProductsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;

@Slf4j
@RequiredArgsConstructor
public class ListProductsUseCaseImpl implements ListProductsUseCase {

    private final ProductGateway productGateway;

    /**
     * Executes the retrieval of a paginated list of products.
     *
     * @param pageable Information about pagination.
     * @return PageableDtoResponse containing a list of products.
     */
    @Override
    public PageableDtoResponse<ProductModelResponse> execute(Pageable pageable) {
        return productGateway.findAll(pageable);
    }

}
