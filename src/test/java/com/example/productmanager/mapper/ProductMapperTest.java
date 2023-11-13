package com.example.productmanager.mapper;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.api.ProductDto;
import com.example.productmanager.data.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    void toDtoTest() {
        Product productEntity = new Product();
        productEntity.setId(1L);
        productEntity.setCreatedAt(Instant.now());
        productEntity.setName("Sample Product");
        productEntity.setDescription("Sample Description");
        productEntity.setPrice(50L);

        ProductDto productDto = productMapper.toDto(productEntity);

        assertEquals(productEntity.getId(), productDto.getId());
        assertEquals(productEntity.getCreatedAt(), productDto.getCreatedAt());
        assertEquals(productEntity.getName(), productDto.getName());
        assertEquals(productEntity.getDescription(), productDto.getDescription());
        assertEquals(productEntity.getPrice(), productDto.getPrice());
    }

    @Test
    void toEntityTest() {
        CreateProductDto productDto = new CreateProductDto();
        productDto.setName("Sample Product");
        productDto.setDescription("Sample Description");
        productDto.setPrice(50L);

        Product productEntity = productMapper.toEntity(productDto);

        assertNull(productEntity.getId());
        assertNull(productEntity.getCreatedAt());
        assertEquals(productDto.getName(), productEntity.getName());
        assertEquals(productDto.getDescription(), productEntity.getDescription());
        assertEquals(productDto.getPrice(), productEntity.getPrice());
    }
}
