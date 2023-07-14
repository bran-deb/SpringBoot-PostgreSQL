package com.app.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.app.crud.models.services.ProductService;
import com.app.crud.models.services.ProductServiceImp;

@Configuration
public class AppConfig {

    @Bean("productService")
    ProductService getProductService() {
        return new ProductServiceImp();
    }
}
