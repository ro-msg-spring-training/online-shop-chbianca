package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private ProductCategory category;
    private Supplier supplier;
    private String imageUrl;

    public static ProductDTO productToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .category(product.getCategory())
                .supplier(product.getSupplier())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public static Product dtoToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setCategory(productDTO.getCategory());
        product.setSupplier(productDTO.getSupplier());
        product.setImageUrl(productDTO.getImageUrl());
        return product;
    }
}