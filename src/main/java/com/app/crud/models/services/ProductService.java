package com.app.crud.models.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.crud.models.domain.Product;

public interface ProductService {

    public List<Product> getProducts();

    public ResponseEntity<Object> addProduct(Product product);

    public ResponseEntity<Object> deleteProduct(Long id);

}
