package br.com.lstecnologia.domain.model;

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
public class ProductModel extends GenericModel {

    @NotNull(message = "Name cannot be null")
    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "product")
    private CatalogModel catalog;

}
