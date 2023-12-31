package br.com.lstecnologia.infrastructure.repository.impl;

import br.com.lstecnologia.core.repository.CreateProductRepository;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import br.com.lstecnologia.infrastructure.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CreateProductRepositoryImpl implements CreateProductRepository {

    private final JpaProductRepository productRepository;

    @Override
    public ProductEntity execute(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

}
