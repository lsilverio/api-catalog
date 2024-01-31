package br.com.lstecnologia.adapter.repository;

import br.com.lstecnologia.domain.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing products in the database.
 */
public interface ProductRepository {

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product.
     * @return An Optional containing the product, or empty if not found.
     */
    Optional<ProductModel> findById(Long id);

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    List<ProductModel> findAll();

    /**
     * Retrieves all products with pagination.
     *
     * @param pageable Object to define pagination parameters.
     * @return A page of products.
     */
    Page<ProductModel> findAll(Pageable pageable);

    /**
     * Saves a product in the database.
     *
     * @param product The product to be saved.
     * @return The saved product.
     */
    ProductModel save(ProductModel product);

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to be deleted.
     */
    void deleteById(Long id);

    /**
     * Checks if a product with the given name exists.
     *
     * @param name The name to check for existence.
     * @return True if a product with the given name exists, false otherwise.
     */
    boolean existsByName(String name);

}
