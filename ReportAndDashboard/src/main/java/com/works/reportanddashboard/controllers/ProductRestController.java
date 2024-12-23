package com.works.reportanddashboard.controllers;

import com.works.reportanddashboard.entities.Product;
import com.works.reportanddashboard.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductRestController {

    private ProductService productService;
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("saveAll")
    public List<Product> saveProducts(@Valid @RequestBody List<Product> products) {
        return productService.saveProduct(products);
    }
}
