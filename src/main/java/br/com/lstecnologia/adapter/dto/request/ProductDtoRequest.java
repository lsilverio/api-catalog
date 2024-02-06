package br.com.lstecnologia.adapter.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO representing the request payload for creating a new product.
 */
public record ProductDtoRequest(
        @NotBlank(message = "Name cannot be null") String name) {
}
