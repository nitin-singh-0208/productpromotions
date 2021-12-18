package com.example.productpromotions.jobs;

import com.example.productpromotions.service.ProductService;
import com.example.productpromotions.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Component
@Slf4j
public class ProductImportJob {

    @Autowired
    ProductService productService;

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ProductDTO[] products = restTemplate
                .exchange("https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest",
                        HttpMethod.GET, entity, ProductDTO[].class).getBody();
        if (products != null) {
            for (ProductDTO product : products) {
                productService.createOrUpdateProduct(product);
            }
        } else {
            log.warn("No products to save");
        }
    }
}
