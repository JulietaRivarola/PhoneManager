package com.julir.phonemanager.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
public class ProductDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private Double price;
  private String color;
}
