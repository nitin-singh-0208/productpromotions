package com.example.productpromotions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String category;
    private int inventory;
    private float rating;
    private String currency;
    private BigDecimal price;
    private String origin;
    private String product;
    private String arrival;
}
