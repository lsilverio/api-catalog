package br.com.lstecnologia.core.usecase;

import br.com.lstecnologia.application.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.service.CreateProductService;
import br.com.lstecnologia.core.exception.ExistsProductByNameException;
import br.com.lstecnologia.core.mapper.ProductMapper;
import br.com.lstecnologia.core.repository.CreateProductRepository;
import br.com.lstecnologia.core.repository.ExistsByNameProductRepository;
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
    private final ExistsByNameProductRepository existsByNameProductRepository;

    @Override
    public ProductResponseDto execute(@Valid ProductRequestDto productRequestDto) {

        if(existsByNameProductRepository.execute(productRequestDto.name())) {
            throw new ExistsProductByNameException("Exists product by name");
        }

        ProductEntity productEntity = createProductRepository.execute(
                productMapper.toEntity(
                        productMapper.toDomain(productRequestDto)
                )
        );

        return productMapper.toResponseDto(
                productMapper.toDomain(productEntity)
        );
    }

}
