package com.example.productpromotions.repository;

import com.example.productpromotions.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByCategoryAndOriginAndProduct(String category, String origin, String product);
}
