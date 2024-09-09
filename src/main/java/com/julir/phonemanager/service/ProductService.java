package com.julir.phonemanager.service;

import com.julir.phonemanager.dto.ProductDto;
import com.julir.phonemanager.mapper.ProductMapper;
import com.julir.phonemanager.model.Product;
import com.julir.phonemanager.model.ProductDetail;
import com.julir.phonemanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<ProductDto> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return ProductMapper.toDTOList(products);
  }

  public Product saveProduct(Product product) {
    if (product.getData() != null) {
      for (ProductDetail detail : product.getData()) {
        detail.setProduct(product);
      }
    }
    return productRepository.save(product);
  }
}