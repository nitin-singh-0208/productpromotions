package com.example.productpromotions.service.promotion;

import com.example.productpromotions.DiscountedProduct;

import java.math.BigDecimal;

public class PromotionGroupBRule extends AbstractPromotionRule {
    public boolean apply(DiscountedProduct discountedProduct) {
        applyGroupBDiscounts(discountedProduct);
        return applyNextRuleIfApplicable(discountedProduct);

    }

    private void applyGroupBDiscounts(DiscountedProduct discountedProduct) {
        if (discountedProduct.getProduct().getInventory() > 20) {
            discountedProduct.applyPercentageDiscountIfbestValue(BigDecimal.valueOf(12));
        }
        if (discountedProduct.getProduct().getArrival() != null && discountedProduct.getProduct().getArrival().equalsIgnoreCase("NEW")) {
            discountedProduct.applyPercentageDiscountIfbestValue(BigDecimal.valueOf(7));
        }
    }
}
