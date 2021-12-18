package com.example.productpromotions.service;

import com.example.productpromotions.dto.ProductDTO;
import com.example.productpromotions.entity.Product;
import com.example.productpromotions.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Value("#{${price.conversion.matrix}}")
    private Map<String, Map<String, BigDecimal>> priceMatrix;


    public Product createOrUpdateProduct(ProductDTO productTO) {
        Product product;
        if ((product = productRepository.findByCategoryAndOriginAndProduct(productTO.getCategory(), productTO.getOrigin(), productTO.getProduct())) != null) {
            product.setInventory(productTO.getInventory());
            product.setRating(productTO.getRating());
            product.setSupplierPrice(productTO.getPrice());
        } else {
            product = new Product();
            product.setCategory(productTO.getCategory());
            product.setInventory(productTO.getInventory());
            product.setRating(productTO.getRating());
            product.setSupplierCurrency(productTO.getCurrency());
            product.setSupplierPrice(productTO.getPrice());
            product.setOrigin(productTO.getOrigin());
            product.setProduct(productTO.getProduct());
            product.setCurrency("INR");
            product.setPrice(convertToINR(productTO.getCurrency(), productTO.getPrice()));
        }
        return productRepository.save(product);

    }

    private BigDecimal convertToINR(String supplierCurrency, BigDecimal price) {
        return priceMatrix.get("INR").get(supplierCurrency.toUpperCase()).multiply(price);
    }

    public final Product fetchProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
