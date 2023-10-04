package br.com.lstecnologia.infrastructure.repository.impl;

import br.com.lstecnologia.core.repository.ExistsByNameProductRepository;
import br.com.lstecnologia.infrastructure.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ExistsByNameProductRepositoryImpl implements ExistsByNameProductRepository {

    private final JpaProductRepository productRepository;

    @Override
    public boolean execute(String name) {
        return productRepository.existsByName(name);
    }

}
