package br.com.lstecnologia.framework.persistence;

import br.com.lstecnologia.domain.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for the {@link ProductModel} entity.
 */
@Repository
public interface JpaProductRepository extends JpaRepository<ProductModel, Long> {

    /**
     * Check if a product with the given name exists.
     *
     * @param name The name of the product.
     * @return {@code true} if a product with the given name exists, {@code false} otherwise.
     */
    boolean existsByName(String name);

}
