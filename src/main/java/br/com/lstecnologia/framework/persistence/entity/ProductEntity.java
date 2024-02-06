/**
 * Represents a product in the system with a unique name. It can be associated with a catalog.
 */
package br.com.lstecnologia.framework.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity extends GenericEntity {

    @NotNull(message = "Name cannot be null")
    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "product")
    private CatalogEntity catalog;

}
