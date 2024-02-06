package br.com.lstecnologia.adapter.controller;

import br.com.lstecnologia.adapter.dto.request.ProductDtoRequest;
import br.com.lstecnologia.adapter.dto.response.ErrorDtoResponse;
import br.com.lstecnologia.adapter.dto.response.ProductDtoResponse;
import br.com.lstecnologia.adapter.mapper.ProductAdapterMapper;
import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import br.com.lstecnologia.application.useCase.CreateProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class CreateProductController {

    private final ProductAdapterMapper productAdapterMapper;
    private final CreateProductUseCase createProductUseCase;

    /**
     * Endpoint to create a new product.
     *
     * @param productDtoRequest The request payload containing information for creating the product.
     * @return ResponseEntity containing the details of the created product.
     */
    @Tag(name = "Product")
    @Operation(summary = "Create Product", description = "Creates a new product with the provided information.")
    @ApiResponse(responseCode = "201", description = "Product created successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDtoResponse.class)))
    @ApiResponse(responseCode = "400", description = "A product with the same name already exists.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDtoResponse.class)))
    @PostMapping
    public ResponseEntity<ProductDtoResponse> execute(@Valid @RequestBody ProductDtoRequest productDtoRequest) {
        log.info("Received request to create product: {}", productDtoRequest);

        ProductModelRequest productModelRequest = productAdapterMapper.toModelRequest(productDtoRequest);
        ProductModelResponse productModelResponse = createProductUseCase.execute(productModelRequest);
        ProductDtoResponse productDtoResponse = productAdapterMapper.toDtoResponse(productModelResponse);

        log.info("Product created successfully: {}", productDtoResponse);

        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(productDtoResponse.getId())
                        .toUri())
                .body(productDtoResponse);
    }
}
