package com.example.productpromotions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private int inventory;
    private float rating;
    private String supplierCurrency;
    private BigDecimal supplierPrice;
    private String currency;
    private BigDecimal price;
    private String origin;
    private String product;
    private String arrival;

}
