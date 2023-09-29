package br.com.lstecnologia.core.mapper;

import br.com.lstecnologia.application.controller.dto.request.ProductRequestDto;
import br.com.lstecnologia.application.controller.dto.response.ProductResponseDto;
import br.com.lstecnologia.core.domain.ProductDomain;
import br.com.lstecnologia.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDomain toDomain(ProductEntity productEntity);

    ProductDomain toDomain(ProductRequestDto productRequestDto);

    ProductResponseDto toResponseDto(ProductDomain productDomain);

    ProductEntity toEntity(ProductDomain productDomain);

}
