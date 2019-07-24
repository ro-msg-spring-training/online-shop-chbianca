package ro.msg.learning.shop.dto;

import lombok.Data;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import java.math.BigDecimal;
import java.util.function.Consumer;

@Data
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private ProductCategory category;
    private Supplier supplier;
    private String imageUrl;


    public ProductDTO(Integer id, String name, String description, BigDecimal price, Double weight,  ProductCategory category, Supplier supplier, String imageUrl) {
        super();
        this.id = id;
        this.name= name;
        this.description= description;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.supplier =  supplier;
        this.imageUrl = imageUrl;
    }

    public static ProductDTO productToDTO (Product product){
        ProductDTO productDto = new ProductDTO.ProductBuilder()
                .with($ -> {
                    $.nestedId = product.getId();
                    $.nestedName = product.getName();
                    $.nestedDescription = product.getDescription();
                    $.nestedPrice = product.getPrice();
                    $.nestedWeight = product.getWeight();
                    $.nestedCategory = product.getCategory();
                    $.nestedSupplier = product.getSupplier();
                    $.nestedImageUrl = product.getImageUrl();
                })
                .createProduct();
        return productDto;
    }

    public static Product dtoToProduct (ProductDTO productDTO) {
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

    public static class ProductBuilder {
        public Integer nestedId;
        public String nestedName;
        public String nestedDescription;
        public BigDecimal nestedPrice;
        public Double nestedWeight;
        public ProductCategory nestedCategory;
        public Supplier nestedSupplier;
        public String nestedImageUrl;

        public ProductBuilder with(
                Consumer<ProductBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public ProductDTO createProduct() {
            return new ProductDTO(nestedId, nestedName, nestedDescription, nestedPrice, nestedWeight, nestedCategory, nestedSupplier, nestedImageUrl);
        }
    }

}