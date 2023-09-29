package br.com.lstecnologia.application.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProductRequestDto(
        @NotBlank(message = "Name cannot be null")
        String name) {
}