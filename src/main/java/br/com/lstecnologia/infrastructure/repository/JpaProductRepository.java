package br.com.lstecnologia.infrastructure.repository;

import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByName(String name);

}
