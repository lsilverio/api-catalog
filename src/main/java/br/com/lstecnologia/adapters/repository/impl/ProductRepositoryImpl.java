package br.com.lstecnologia.adapters.repository.impl;

import br.com.lstecnologia.entities.model.ProductModel;
import br.com.lstecnologia.frameworks.persistence.JpaProductRepository;
import br.com.lstecnologia.adapters.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link ProductRepository} interface using Spring Data JPA.
 */
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository productRepository;

    @Override
    public Optional<ProductModel> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<ProductModel> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public ProductModel save(ProductModel productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

}
