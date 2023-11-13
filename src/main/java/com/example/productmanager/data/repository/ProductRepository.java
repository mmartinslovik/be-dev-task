package com.example.productmanager.data.repository;

import com.example.productmanager.data.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

}
