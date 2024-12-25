package com.works.reportanddashboard.services;

import com.works.reportanddashboard.entities.Product;
import com.works.reportanddashboard.repositories.ProductRepository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    final ProductRepository productRepository;
    final CacheManager cacheManager;
    public ProductService(ProductRepository productRepository, CacheManager cacheManager) {
        this.productRepository = productRepository;
        this.cacheManager = cacheManager;
    }

    public List<Product> saveProduct(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    public void productListener(Product product){
        productRepository.save(product);
        cacheManager.getCache("product").clear();
    }

    @Cacheable("product")
    public Page<Product> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return productRepository.findAll(pageable);

    }
}
