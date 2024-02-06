package br.com.lstecnologia.domain.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a response model for Catalog entities.
 */
@Data
public class CatalogModelResponse extends GenericModelResponse implements Serializable {

    private static final long serialVersionUID = 6967287038577110988L;

    private ProductModelResponse product;
    private BigDecimal price;
    private LocalDateTime startValidityDate;
    private LocalDateTime endValidityDate;

}
