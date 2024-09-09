package com.julir.phonemanager.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
  private Long id;
  private String name;
  private String brand;
  private String model;
  private List<ProductDetailDto> data;
}
