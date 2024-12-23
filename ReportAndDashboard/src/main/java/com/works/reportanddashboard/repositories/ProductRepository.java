package com.works.reportanddashboard.repositories;

import com.works.reportanddashboard.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
