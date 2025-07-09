package com.example.ecommerce.repository;


import com.example.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.example.ecommerce.repository
 * File: ProductRepository.java
 * Author: Ochwada
 * Date: Wednesday, 09.Jul.2025, 11:47 AM
 * Description: Repository interface for the `Product` document.  Spring Data MongoDB automatically implements the
 *  *interface at runtime, providing built-in CRUD methods
 * Objective:
 * *******************************************************
 */

/**
 * As long as we are extending MongoRepository, the @Repository annotation is optional.
 * Spring Data MongoDB will automatically detect this interface during component scanning and create a proxy bean at runtime.
 */

public interface ProductRepository extends MongoRepository<Product , String> {

    // MongoRepository provides out-of-the-box CRUD methods like:
    // - findAll()
    // - findById(String id)
    // - insert(Product product)
    // - deleteById(String id)
    // - count()

    // You can also define custom query methods here.
    // For example: List<Product> findByCategory(String category);
    // Optional<Product> findByName(String name);
}
