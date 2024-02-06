package br.com.lstecnologia.domain.model.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a request model for Catalog entities.
 */
public record CatalogModelRequest(
        BigDecimal price,
        LocalDateTime startValidityDate,
        LocalDateTime endValidityDate) {
}

