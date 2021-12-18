package com.example.productpromotions;

import com.example.productpromotions.entity.Product;
import com.example.productpromotions.service.ProductService;
import com.example.productpromotions.service.promotion.CommonPromotionGroupRule;
import com.example.productpromotions.service.promotion.PromotionGroupARule;
import com.example.productpromotions.service.promotion.PromotionGroupBRule;
import com.example.productpromotions.service.promotion.PromotionRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/applyPromotionRuleAll/{id}")
    public DiscountedProduct getDiscountedProductForAllRules(@RequestParam("id") long productId) {
        Product product = productService.fetchProductById(productId);
        DiscountedProduct discountedProduct = null;
        if (product != null) {
            discountedProduct = new DiscountedProduct(product);
            PromotionRule firstRule = new PromotionGroupARule();
            PromotionRule secondRule = new PromotionGroupBRule();
            PromotionRule commonPromotionRule = new CommonPromotionGroupRule();
            firstRule.setNextRule(secondRule);
            secondRule.setNextRule(commonPromotionRule);
            commonPromotionRule.setNextRule(null);
        }

        return discountedProduct;
    }

    @GetMapping("/applyPromotionRuleA/{id}")
    public DiscountedProduct getDiscountedProductForGroupA(@RequestParam("id") long productId) {
        return null;
    }

    @GetMapping("/applyPromotionRuleB/{id}")
    public DiscountedProduct getDiscountedProductForGroupB(@RequestParam("id") long productId) {
        return null;
    }
}
