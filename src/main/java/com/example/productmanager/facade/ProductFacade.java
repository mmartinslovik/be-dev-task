package com.example.productmanager.facade;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.api.ProductDto;

import java.util.List;

public interface ProductFacade {

    ProductDto create(CreateProductDto createProductDto);

    List<ProductDto> getAll();
}
