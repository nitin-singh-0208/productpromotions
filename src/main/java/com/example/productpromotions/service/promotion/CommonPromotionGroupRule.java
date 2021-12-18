package com.example.productpromotions.service.promotion;

import com.example.productpromotions.DiscountedProduct;

import java.math.BigDecimal;

public class CommonPromotionGroupRule extends AbstractPromotionRule {
    public boolean apply(DiscountedProduct discountedProduct) {
        applyCommonGroupDiscount(discountedProduct);
        return applyNextRuleIfApplicable(discountedProduct);

    }

    private void applyCommonGroupDiscount(DiscountedProduct discountedProduct) {
        if (!discountedProduct.isDiscountApplied() && (discountedProduct.getProduct().getPrice().compareTo(BigDecimal.valueOf(1000)) > 0)) {
            discountedProduct.applyPercentageDiscountIfbestValue(BigDecimal.valueOf(2));
        }
    }
}
