package br.com.lstecnologia.adapter.controller;

import br.com.lstecnologia.useCase.dto.response.PageableResponseDto;
import br.com.lstecnologia.useCase.dto.response.ProductResponseDto;
import br.com.lstecnologia.useCase.service.ListProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ListProductsController {

    private final ListProductsService listProductsService;

    /**
     * Endpoint to list products.
     *
     * @param pageable Information about pagination.
     * @return ResponseEntity with PageableResponseDto containing a list of products.
     */
    @Tag(name = "Product")
    @Operation(summary = "List Products", description = "Retrieve the list of all registered products.")
    @ApiResponse(responseCode = "200", description = "List of products retrieved successfully.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PageableResponseDto.class)))
    @GetMapping
    public ResponseEntity<PageableResponseDto<ProductResponseDto>> execute(Pageable pageable) {
        return ResponseEntity.ok(
                listProductsService.execute(pageable)
        );
    }

}
