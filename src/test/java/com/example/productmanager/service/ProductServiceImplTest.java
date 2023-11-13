package com.example.productmanager.service;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.data.model.Product;
import com.example.productmanager.data.repository.ProductRepository;
import com.example.productmanager.mapper.ProductMapper;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductMapper productMapper;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        ProductRepository productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository, Validation.buildDefaultValidatorFactory().getValidator());

        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Sample Product");

        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);
        when(productRepository.findAll()).thenReturn(Collections.singletonList(mockProduct));
    }

    @Test
    void findAllProductsTest() {
        List<Product> retrievedProducts = productService.findAll();

        assertEquals(1, retrievedProducts.size());

        Product retrievedProduct = retrievedProducts.get(0);

        assertEquals(1L, retrievedProduct.getId());
        assertEquals("Sample Product", retrievedProduct.getName());
    }

}
