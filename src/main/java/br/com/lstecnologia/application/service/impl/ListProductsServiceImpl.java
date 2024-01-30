package br.com.lstecnologia.application.service.impl;

import br.com.lstecnologia.application.dto.response.PageableResponseDto;
import br.com.lstecnologia.application.dto.response.ProductResponseDto;
import br.com.lstecnologia.application.mapper.ProductResponseDtoMapper;
import br.com.lstecnologia.domain.entity.ProductEntity;
import br.com.lstecnologia.domain.service.ListProductsService;
import br.com.lstecnologia.framework.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class ListProductsServiceImpl implements ListProductsService {

    private final ProductResponseDtoMapper productResponseDtoMapper;
    private final ProductRepository productRepository;

    @Override
    public PageableResponseDto<ProductResponseDto> execute(Pageable pageable) {
        return pageable(
                productRepository.findAll(pageable)
        );
    }

    /**
     * Converts a Page of ProductEntity to a PageableResponseDto of ProductResponseDto.
     *
     * @param productEntityPage Page containing entities representing products.
     * @return PageableResponseDto containing the list of products in the response.
     */
    private PageableResponseDto<ProductResponseDto> pageable(Page<ProductEntity> productEntityPage) {

        List<ProductResponseDto> productResponseDtoList = productEntityPage.getContent().stream()
                .map(p -> productResponseDtoMapper.toResponseDto(p))
                .collect(Collectors.toList());

        return new PageableResponseDto(productEntityPage, productResponseDtoList);
    }

}
