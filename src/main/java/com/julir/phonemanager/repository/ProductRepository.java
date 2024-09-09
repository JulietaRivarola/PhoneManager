package com.julir.phonemanager.repository;

import com.julir.phonemanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}