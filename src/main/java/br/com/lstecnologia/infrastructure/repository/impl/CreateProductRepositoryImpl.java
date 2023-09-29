package br.com.lstecnologia.infrastructure.repository.impl;

import br.com.lstecnologia.core.usecase.repository.CreateProductRepository;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import br.com.lstecnologia.infrastructure.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CreateProductRepositoryImpl implements CreateProductRepository {

    private final JpaProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        ProductEntity saved = productRepository.save(productEntity);
        return saved;
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

}
