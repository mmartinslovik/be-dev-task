package com.example.productmanager.api;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductDtoTest {

    @Test
    void testValidProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setCreatedAt(Instant.now());
        productDto.setName("Example Product");
        productDto.setDescription("This is a sample product.");
        productDto.setPrice(50L);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);

        assertTrue(violations.isEmpty());
    }

    @Test
    void testInvalidProductDto() {
        ProductDto productDto = new ProductDto();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);

        assertFalse(violations.isEmpty());

        assertTrue(violations.stream()
                .anyMatch(violation -> "name".equals(violation.getPropertyPath().toString())));

        assertTrue(violations.stream()
                .anyMatch(violation -> "price".equals(violation.getPropertyPath().toString())));
    }
}
