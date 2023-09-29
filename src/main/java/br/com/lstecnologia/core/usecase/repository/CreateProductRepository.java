package br.com.lstecnologia.core.usecase.repository;

import br.com.lstecnologia.infrastructure.entity.ProductEntity;

public interface CreateProductRepository {

    ProductEntity save(ProductEntity productEntity);

    boolean existsByName(String name);

}
