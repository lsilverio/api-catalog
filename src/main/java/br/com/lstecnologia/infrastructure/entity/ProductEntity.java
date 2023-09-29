package br.com.lstecnologia.infrastructure.entity;

import br.com.lstecnologia.infrastructure.entity.common.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity extends GenericEntity {

    @NotNull(message = "Name cannot be null")
    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "product")
    private CatalogEntity catalog;

}
