package com.example.productmanager.mapper;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.api.ProductDto;
import com.example.productmanager.data.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(CreateProductDto createProductDto);

    ProductDto toDto(Product product);
}
