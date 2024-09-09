package com.julir.phonemanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetailDto {
  private Long id;
  private Double price;
  private String color;
}
