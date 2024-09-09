package com.julir.phonemanager.controller;

import com.julir.phonemanager.dto.ProductDto;
import com.julir.phonemanager.model.Product;
import com.julir.phonemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<ProductDto> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    return ResponseEntity.ok(productService.saveProduct(product));
  }
}