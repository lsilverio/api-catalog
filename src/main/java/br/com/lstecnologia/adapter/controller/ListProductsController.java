package br.com.lstecnologia.adapter.controller;

import br.com.lstecnologia.adapter.dto.response.PageableDtoResponse;
import br.com.lstecnologia.adapter.dto.response.ProductDtoResponse;
import br.com.lstecnologia.adapter.mapper.ProductAdapterMapper;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import br.com.lstecnologia.application.useCase.ListProductsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ListProductsController {

    private final ProductAdapterMapper productAdapterMapper;
    private final ListProductsUseCase listProductsUseCase;

    /**
     * Endpoint to list products.
     *
     * @param pageable Information about pagination.
     * @return ResponseEntity with PageableDtoResponse containing a list of products.
     */
    @Tag(name = "Product")
    @Operation(summary = "List Products", description = "Retrieve the list of all registered products.")
    @ApiResponse(responseCode = "200", description = "List of products retrieved successfully.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PageableDtoResponse.class)))
    @GetMapping
    public ResponseEntity<PageableDtoResponse<ProductDtoResponse>> execute(@PageableDefault(size = 10) Pageable pageable) {

        PageableDtoResponse<ProductModelResponse> response = listProductsUseCase.execute(pageable);

        return ResponseEntity.ok(
                new PageableDtoResponse<ProductDtoResponse>(
                        response.getTotalPages(),
                        response.getTotalElements(),
                        response.getNumberOfElementsCurrentPage(),
                        response.getNumberOfCurrentPage(),
                        response.isFirstPage(),
                        response.isLastPage(),
                        response.getElements()
                                .stream()
                                .map(model -> productAdapterMapper.toDtoResponse(model))
                                .collect(Collectors.toList()))
        );
    }
}
