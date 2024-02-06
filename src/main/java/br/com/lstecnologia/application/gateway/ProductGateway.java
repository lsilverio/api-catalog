package br.com.lstecnologia.application.gateway;

import br.com.lstecnologia.adapter.dto.response.PageableDtoResponse;
import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing products in the database.
 */
public interface ProductGateway {

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product.
     * @return An Optional containing the product, or empty if not found.
     */
    Optional<ProductModelResponse> findById(Long id);

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    List<ProductModelResponse> findAll();

    /**
     * Retrieves all products with pagination.
     *
     * @param pageable Object to define pagination parameters.
     * @return A page of products.
     */
    PageableDtoResponse<ProductModelResponse> findAll(Pageable pageable);

    /**
     * Saves a productModel in the database.
     *
     * @param productModelRequest The productModel to be saved.
     * @return The saved productModel.
     */
    ProductModelResponse save(ProductModelRequest productModelRequest);

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
