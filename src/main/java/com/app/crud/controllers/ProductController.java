package com.app.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.models.domain.Product;
import com.app.crud.models.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // @Qualifier("productService")
    @Autowired
    private final ProductService productServiceImp;

    public ProductController(ProductService productServiceImp) {
        this.productServiceImp = productServiceImp;
    }

    @GetMapping("/")
    public List<Product> getProducts() {
        return productServiceImp.getProducts();
    }

    @PostMapping("/")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return this.productServiceImp.addProduct(product);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return this.productServiceImp.addProduct(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProductPath(@PathVariable("productId") Long id) {
        return this.productServiceImp.deleteProduct(id);
    }
}
