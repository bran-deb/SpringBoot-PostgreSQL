package com.app.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crud.models.domain.Product;

// @Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // CUSTOM QUERY - METHOD
    // @Query("SELECT * FROM Product p WHERE p.name = ?1")
    Optional<Product> findByName(String name);
}
