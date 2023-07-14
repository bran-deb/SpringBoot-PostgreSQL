package com.app.crud.models.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.app.crud.models.domain.Product;
import com.app.crud.repository.ProductRepository;

public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    HashMap<String, Object> response;

    public ProductServiceImp() {
    }

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> addProduct(Product product) {
        Optional<Product> productExist = this.productRepository.findByName(product.getName());
        response = new HashMap<>();

        if (productExist.isPresent() && product.getId() == null) {
            response.put("error", HttpStatusCode.valueOf(400));
            response.put("message", "Ya existe un producto con ese nombre");
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
        }
        response.put("message", "Producto creado con exito");

        if (product.getId() != null) {
            response.put("data", product);
            response.put("message", "Producto actualizado con exito");
        }

        this.productRepository.save(product);
        response.put("data", product);
        return new ResponseEntity<>(response, HttpStatus.valueOf(201));
    }

    @Override
    public ResponseEntity<Object> deleteProduct(Long id) {
        Boolean productIdExist = this.productRepository.existsById(id);
        response = new HashMap<>();

        if (!productIdExist) {
            response.put("error", HttpStatusCode.valueOf(404));
            response.put("message", "El producto no existe");
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(404));
        }

        this.productRepository.deleteById(id);
        response.put("data", productRepository.findAll());
        response.put("message", "Producto eliminado con exito");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }
}
