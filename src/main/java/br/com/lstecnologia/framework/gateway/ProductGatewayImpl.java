package br.com.lstecnologia.framework.gateway;

import br.com.lstecnologia.adapter.dto.response.PageableDtoResponse;
import br.com.lstecnologia.domain.model.request.ProductModelRequest;
import br.com.lstecnologia.domain.model.response.ProductModelResponse;
import br.com.lstecnologia.framework.exception.ObjectNotFoundException;
import br.com.lstecnologia.framework.mapper.ProductEntityMapper;
import br.com.lstecnologia.framework.persistence.repository.JpaProductRepository;
import br.com.lstecnologia.framework.persistence.entity.ProductEntity;
import br.com.lstecnologia.application.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link ProductGateway} interface using Spring Data JPA.
 */
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {

    private final ProductEntityMapper productEntityMapper;
    private final JpaProductRepository productRepository;

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return An {@link Optional} containing the retrieved product or an empty {@link Optional} if not found.
     * @throws ObjectNotFoundException if the product with the specified ID is not found.
     */
    @Override
    public Optional<ProductModelResponse> findById(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Product not found with ID: " + id));

        return Optional.ofNullable(productEntityMapper.toModelResponse(productEntity));
    }

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    @Override
    public List<ProductModelResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> productEntityMapper.toModelResponse(p))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a paginated list of products.
     *
     * @param pageable The information about pagination.
     * @return A {@link PageableDtoResponse} containing the paginated list of products.
     */
    @Override
    public PageableDtoResponse<ProductModelResponse> findAll(Pageable pageable) {
        Page<ProductEntity> response = productRepository.findAll(pageable);

        return new PageableDtoResponse<>(
                response.getTotalPages(),
                response.getTotalElements(),
                response.getNumberOfElements(),
                response.getNumber(),
                response.isFirst(),
                response.isLast(),
                response.getContent()
                        .stream()
                        .map(p -> productEntityMapper.toModelResponse(p))
                        .collect(Collectors.toList()));
    }

    /**
     * Saves a new product.
     *
     * @param productModelRequest The information needed to create the new product.
     * @return The created product.
     */
    @Override
    public ProductModelResponse save(ProductModelRequest productModelRequest) {
        ProductEntity productEntity = productEntityMapper.toEntity(productModelRequest);
        productEntity = productRepository.save(productEntity);
        return productEntityMapper.toModelResponse(productEntity);
    }

    /**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Checks if a product with the specified name exists.
     *
     * @param name The name of the product.
     * @return {@code true} if a product with the specified name exists, {@code false} otherwise.
     */
    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

}
