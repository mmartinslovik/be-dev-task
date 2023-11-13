package com.example.productmanager.service;

import com.example.productmanager.data.model.Product;
import com.example.productmanager.data.repository.ProductRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, Validator validator) {
        super(productRepository, validator);
    }
}
