package com.example.ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * *******************************************************
 * Package: com.example.ecommerce.model
 * File: Product.java
 * Author: Ochwada
 * Date: Wednesday, 09.Jul.2025, 10:58 AM
 * Description: Represent a product in our eCommerce catalog.
 * Objective: Product Model
 * *******************************************************
 */

@Data // Lombok annotation to automatically generate getters, setters, toString(), equals(), and hashCode() methods.
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor // exclude id from all arg constructor
@Document(collection = "products")
public class Product {
    /** Unique identifier for the product */
    @Id
    private  String id;

    /** Name of the product */
    private  String name;

    /** Product's description*/
    private String description;

    /** price of the product*/
    private Double price;

    /** The category the product belongs to*/
    private  String category;
}
