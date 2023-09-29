package br.com.lstecnologia.core.usecase;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.service.CreateProductService;
import br.com.lstecnologia.core.domain.ProductDomain;
import br.com.lstecnologia.core.exception.ExistsProductByNameException;
import br.com.lstecnologia.core.mapper.ProductMapper;
import br.com.lstecnologia.core.usecase.repository.CreateProductRepository;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateProductUseCase implements CreateProductService {

    private final ProductMapper productMapper;
    private final CreateProductRepository createProductRepository;

    @Override
    public ProductResponseDto execute(@Valid ProductRequestDto productRequestDto) {

        ProductDomain productDomain = productMapper.toDomain(productRequestDto);
        ProductEntity productEntity = productMapper.toEntity(productDomain);

        if(createProductRepository.existsByName(productEntity.getName())) {
            throw new ExistsProductByNameException("Exists product by name");
        }

        productEntity = createProductRepository.save(productEntity);
        productDomain = productMapper.toDomain(productEntity);

        return productMapper.toResponseDto(productDomain);
    }

}
