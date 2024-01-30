package br.com.lstecnologia.application.service.impl;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.mapper.ProductEntityMapper;
import br.com.lstecnologia.application.mapper.ProductResponseDtoMapper;
import br.com.lstecnologia.application.service.exception.ExistsProductByNameException;
import br.com.lstecnologia.domain.entity.ProductEntity;
import br.com.lstecnologia.domain.service.CreateProductService;
import br.com.lstecnologia.framework.persistence.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateProductServiceImpl implements CreateProductService {

    private final ProductResponseDtoMapper productResponseDtoMapper;
    private final ProductEntityMapper productEntityMapper;
    private final ProductRepository productRepository;

    /**
     * Executes the creation of a new product based on the provided request.
     *
     * @param productRequestDto Request containing information for creating the product.
     * @return Response with details of the created product.
     * @throws ExistsProductByNameException if a product with the same name already exists.
     */
    @Override
    public ProductResponseDto execute(@Valid ProductRequestDto productRequestDto) {

        if(productRepository.existsByName(productRequestDto.name())) {
            throw new ExistsProductByNameException("Exists product by name");
        }

        ProductEntity productEntity = productRepository.save(productEntityMapper.toEntity(productRequestDto));

        return productResponseDtoMapper.toResponseDto(productEntity);
    }

}
