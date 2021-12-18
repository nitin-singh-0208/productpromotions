package com.example.productpromotions.service.promotion;

import com.example.productpromotions.DiscountedProduct;

public interface PromotionRule {
    public void setNextRule(PromotionRule nextRule);

    public boolean applyNextRuleIfApplicable(DiscountedProduct discountedProduct);
}
