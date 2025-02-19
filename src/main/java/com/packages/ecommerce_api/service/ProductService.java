package com.packages.ecommerce_api.service;


import com.packages.ecommerce_api.model.Product;
import com.packages.ecommerce_api.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    //public Product updateProduct(Long id, Product product) {
    //    return productRepository.saveAll(id,product);
    //}

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
