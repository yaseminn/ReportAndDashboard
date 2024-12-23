package com.works.reportanddashboard.services;

import com.works.reportanddashboard.entities.Product;
import com.works.reportanddashboard.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> saveProduct(List<Product> productList) {
        return productRepository.saveAll(productList);
    }
}
