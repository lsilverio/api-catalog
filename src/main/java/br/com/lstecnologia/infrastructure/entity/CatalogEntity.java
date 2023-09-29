package br.com.lstecnologia.infrastructure.entity;

import br.com.lstecnologia.infrastructure.entity.common.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "catalog")
public class CatalogEntity extends GenericEntity {

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "timestamp", name = "start_validity_date")
    private LocalDateTime startValidityDate;

    @Column(nullable = false, columnDefinition = "timestamp", name = "end_validity_date")
    private LocalDateTime endValidityDate;

}
