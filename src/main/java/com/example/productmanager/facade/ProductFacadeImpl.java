package com.example.productmanager.facade;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.api.ProductDto;
import com.example.productmanager.mapper.ProductMapper;
import com.example.productmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductFacadeImpl(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto create(CreateProductDto createProductDto) {
        return productMapper.toDto(productService.save(productMapper.toEntity(createProductDto)));
    }

    @Override
    public List<ProductDto> getAll() {
        return productService.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
}
