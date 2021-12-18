package com.example.productpromotions.service.promotion;

import com.example.productpromotions.DiscountedProduct;

public class AbstractPromotionRule implements PromotionRule {
    protected PromotionRule nextRule;

    @Override
    public void setNextRule(PromotionRule nextRule) {
        this.nextRule = nextRule;
    }

    @Override
    public boolean applyNextRuleIfApplicable(DiscountedProduct discountedProduct) {
        if (this.nextRule != null) {
            return this.nextRule.applyNextRuleIfApplicable(discountedProduct);
        }
        return false;
    }

}
