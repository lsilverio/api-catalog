package br.com.lstecnologia.core.repository;

import br.com.lstecnologia.infrastructure.entity.ProductEntity;

public interface CreateProductRepository {

    ProductEntity execute(ProductEntity productEntity);

}
