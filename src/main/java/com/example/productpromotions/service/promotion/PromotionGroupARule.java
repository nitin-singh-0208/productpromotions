package com.example.productpromotions.service.promotion;

import com.example.productpromotions.DiscountedProduct;

import java.math.BigDecimal;

public class PromotionGroupARule extends AbstractPromotionRule {
    public boolean apply(DiscountedProduct discountedProduct) {
        applyGroupADiscounts(discountedProduct);
        return applyNextRuleIfApplicable(discountedProduct);

    }

    private void applyGroupADiscounts(DiscountedProduct discountedProduct) {
        if (discountedProduct.getProduct().getOrigin().equalsIgnoreCase("Africa")) {
            discountedProduct.applyPercentageDiscountIfbestValue(BigDecimal.valueOf(7));
        }
        if (discountedProduct.getProduct().getRating() == 2) {
            discountedProduct.applyPercentageDiscountIfbestValue(BigDecimal.valueOf(4));
        }
        if (discountedProduct.getProduct().getRating() < 2) {
            discountedProduct.applyPercentageDiscountIfbestValue(BigDecimal.valueOf(8));
        }
    }
}
