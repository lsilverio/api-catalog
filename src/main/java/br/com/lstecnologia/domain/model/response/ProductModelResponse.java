package br.com.lstecnologia.domain.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Represents a response model for Product entities.
 */
@Data
public class ProductModelResponse extends GenericModelResponse implements Serializable {

    private static final long serialVersionUID = 6967287038017110988L;

    private String name;
    private CatalogModelResponse catalog;

}
