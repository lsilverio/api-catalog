package br.com.lstecnologia.application.controller;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ErrorResponseDto;
import br.com.lstecnologia.application.controller.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.service.CreateProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Criar Produto", description = "Cria um novo produto com as informações fornecidas.")
    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Já existe um produto com o mesmo nome.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class)))
    @PostMapping
    public ResponseEntity<ProductResponseDto> execute(@Valid @RequestBody ProductRequestDto productRequestDto) {

        ProductResponseDto produtcResponseDto = createProductService.execute(productRequestDto);

        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(produtcResponseDto.getId())
                        .toUri())
                .body(produtcResponseDto);
    }

}
