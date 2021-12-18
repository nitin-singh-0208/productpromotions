package com.example.productpromotions;

import com.example.productpromotions.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DiscountedProduct {
    Product product;
    BigDecimal discountedPrice;

    public DiscountedProduct(Product product) {
        this.product = product;
        this.discountedPrice = product.getPrice();
    }

    public boolean isDiscountApplied() {
        return !(product.getPrice().compareTo(discountedPrice) == 0);
    }

    public void applyPercentageDiscountIfbestValue(BigDecimal percentageDiscount) {
        BigDecimal discountAmount = percentageDiscount.multiply(BigDecimal.valueOf(100)).divide(product.getPrice()).setScale(2);
        BigDecimal finalDiscountedAmount = product.getPrice().subtract(discountAmount);
        if (finalDiscountedAmount.compareTo(this.discountedPrice) < 0) {
            this.discountedPrice = finalDiscountedAmount;
        }
    }


}
