package com.example.ecommerce.service;


import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * *******************************************************
 * Package: com.example.ecommerce.service
 * File: ProductService.java
 * Author: Ochwada
 * Date: Wednesday, 09.Jul.2025, 11:56 AM
 * Description: Service layer for Product operations.
 * - Service class for handling business logic related to products.
 * Objective:
 * *******************************************************
 */

/**
 * This layer acts as a bridge between the controller (presentation layer) and the repository (data access layer).
 * It encapsulates application-specific logic such as validation, filtering, transformation, and orchestration of
 * data operations.
 * - Annotated with {@code @Service}, Spring will automatically detect it during component scanning
 * and register it as a bean in the application context.
 */
@Service
public class ProductService {
    // Dependency on the repository layer to perform CRUD operations on Product documents
    private final ProductRepository productRepository;

    /**
     * Constructor-based dependency injection  using @Autowired. (constructor injection of repository)
     * Spring injects ('introduces') an instance of ProductRepository at runtime.
     *
     * @param productRepository The repository used to access Product data from MongoDB
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * ---------------------------------------------------------------------------
     * Business methods like
     * - getAllProducts(), addProduct(), getProductById() etc. go here.
     * ---------------------------------------------------------------------------
     */

    /**
     * Adds a new product to the database.
     * - This method uses `insert()` from Spring Data MongoDB, which performs a true insert operation.
     * - It will throw a DuplicateKeyException if a document with the same `_id` already exists.
     * *
     * - Use this method when you're **sure** the product is new and should not overwrite existing data.
     * - Do NOT use if you want to update an existing product — use `save()` instead.
     *
     * @param product The Product object to be added.
     * @return The inserted Product document, including the generated or provided `_id`.
     */
    public Product addProduct(Product product) {
        return productRepository.insert(product);
    }

    /**
     * Retrieves all products from the MongoDB collection.
     * *
     * This method delegates to the repository's `findAll()` function, which returns a list of all documents in the
     * "products" collection.
     *
     * @return List of all Product objects stored in the database.
     */
    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }

    /**
     * Retrieves a single product by its unique identifier.
     * *
     * This method uses the repository's `findById()` function, which returns
     * an Optional<Product>. If the product exists, the Optional will contain
     * the product; otherwise, it will be empty.
     *
     * @param id The unique identifier (usually MongoDB's `_id`) of the product.
     * @return An Optional containing the Product if found, or empty if not found.
     */
    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }


    /**
     * Updates an existing Product with the given ID using the provided updated data.
     *
     * @param id The unique identifier of the Product to be updated.
     * @param update The updated Product data. The ID will be set to match the given ID.
     * @return The updated {@link Product saved in the database.
     */
    public Product updateProduct (String id, Product update){
        update.setId(id);
        return  productRepository.save(update);
    }

}
