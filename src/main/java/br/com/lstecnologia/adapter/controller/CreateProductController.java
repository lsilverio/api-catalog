package br.com.lstecnologia.adapter.controller;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.dto.response.ErrorResponseDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.domain.service.CreateProductService;
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

    private final CreateProductService createProductService;

    /**
     * Endpoint to create a new product.
     *
     * @param productRequestDto The request payload containing product information.
     * @return ResponseEntity containing the created product details.
     */
    @Tag(name = "Product")
    @Operation(summary = "Create Product", description = "Creates a new product with the provided information.")
    @ApiResponse(responseCode = "201", description = "Product created successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "A product with the same name already exists.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class)))
    @PostMapping
    public ResponseEntity<ProductResponseDto> execute(@Valid @RequestBody ProductRequestDto productRequestDto) {
        log.info("Received request to create product: {}", productRequestDto);

        ProductResponseDto productResponseDto = createProductService.execute(productRequestDto);

        log.info("Product created successfully: {}", productResponseDto);

        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(productResponseDto.getId())
                        .toUri())
                .body(productResponseDto);
    }

}
