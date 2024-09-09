package com.julir.phonemanager.mapper;

import com.julir.phonemanager.dto.ProductDetailDto;
import com.julir.phonemanager.dto.ProductDto;
import com.julir.phonemanager.model.Product;
import com.julir.phonemanager.model.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Component
public interface ProductMapper {

  public static ProductDto toDTO(Product product) {
    return ProductDto.builder()
        .id(product.getId())
        .name(product.getName())
        .brand(product.getBrand())
        .model(product.getModel())
        .data(product.getData() != null
            ? toProductDetailDTOList(product.getData())
            : null)
        .build();
  }

  public static ProductDetailDto toProductDetailDTO(ProductDetail detail) {
    return ProductDetailDto.builder()
        .id(detail.getId())
        .price(detail.getPrice())
        .color(detail.getColor())
        .build();
  }

  public static List<ProductDto> toDTOList(List<Product> products) {
    return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
  }

  private static List<ProductDetailDto> toProductDetailDTOList(List<ProductDetail> details) {
    return details.stream().map(ProductMapper::toProductDetailDTO).collect(Collectors.toList());
  }
}