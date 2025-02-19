package com.packages.ecommerce_api.controller;

import com.packages.ecommerce_api.model.Product;
//import com.packages.ecommerce_api.repository.ProductRepository;
import com.packages.ecommerce_api.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieves a list of all available products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Adds a new product to the catalog")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        product = productService.createProduct(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        
        return ResponseEntity.created(location).body(product);

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieves details of a specific product by its ID")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //@PutMapping("/{id}")
    //@Operation(summary = "Update product by ID", description = "Update product by a specific ID")
    //public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    //    product.setId(id);
    //    return productService.updateProduct(@PathVariable Long id);
    //}

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Removes a product from the catalog")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}


