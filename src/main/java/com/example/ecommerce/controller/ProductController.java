package com.example.ecommerce.controller;


import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * *******************************************************
 * Package: com.example.ecommerce.controller
 * File: ProductController.java
 * Author: Ochwada
 * Date: Wednesday, 09.Jul.2025, 12:27 PM
 * Description: REST Controller for mapping HTTP's Requests' URL's with Java methods.
 * - Used for managing ecommerce data.
 * - Talks to Web Client and Service layer.
 * Objective:
 * *******************************************************
 */


/**
 * This class defines the web layer responsible for routing API requests
 * to the corresponding methods in the ProductService.
 * *
 * It is annotated with @RestController, which is a shorthand for
 * @Controller and @ResponseBody — meaning that all returned values
 * will be automatically serialized to JSON.
 */

@RestController
@RequestMapping("/api/products") // Sets the base URL path for all endpoints defined in this controller. All routes will begin with /api/products.
public class ProductController {

    // Dependency on the ProductService to delegate business logic
    private final ProductService productService;

    /**
     * Constructor-based dependency injection for the ProductService.
     * Spring will automatically inject the required bean at runtime.
     *
     * @param productService the service handling product-related operations
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**-------------------------------------------------------------
     * API endpoints (e.g., @GetMapping, @PostMapping) can be defined here.
     --------------------------------------------------------------*/

    /**
     * Handles HTTP POST requests to create a new product.
     * *
     * This endpoint is mapped to <strong>/api/products/add-product</strong> and is intended to accept a JSON payload
     * representing a new {@link Product}.
     * *
     * The {@code @RequestBody} annotation tells Spring to deserialize the incoming JSON into a {@code Product} object
     * automatically.
     * *
     * Internally, the method delegates to {@code ProductService.addProduct()}, which uses the repository layer to
     * insert the product into MongoDB.
     *
     * @param product The product data sent in the request body (JSON format)
     * @return The newly created Product object as stored in the database
     */
    @PostMapping("/add-product")
    public Product createProduct(@RequestBody Product product){
        return  productService.addProduct(product);
    }

    /**
     * Handles HTTP GET requests to fetch all products.
     * *
     * This endpoint maps to <strong>/api/products</strong> and returns a list of all {@link Product} objects stored in
     * the MongoDB database.
     * *
     * It delegates the logic to {@code productService.getAllProducts()}, which in turn calls the repository layer to
     * fetch all documents from the "products" collection.
     *
     * @return A list of all Product objects in the database.
     */
    @GetMapping
    public List<Product> getAllProducts(){
        return  productService.getAllProducts();
    }

    /**
     * Handles HTTP GET requests to fetch a product by its unique ID.
     * *
     * This endpoint maps to <strong>/api/products/{id}</strong>, where <code>{id}</code> is a path variable
     * representing the MongoDB document ID (usually a String).
     * *
     * The {@code @PathVariable} annotation tells Spring to bind the URL segment to the method parameter.
     *
     * @param id The ID of the product to retrieve.
     * @return An {@link Optional} containing the Product if found, or empty if not found.
     */
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id){
        return  productService.getProductById(id);
    }
}
