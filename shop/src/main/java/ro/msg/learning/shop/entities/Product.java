package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table
public class Product extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne
    private ProductCategory category;

    @ManyToOne
    private Supplier supplier;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    private Set<Stock> stoks;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    public Product(Integer id, String name, String description, BigDecimal price, Double weight, ProductCategory category, Supplier supplier, String imageUrl) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.supplier = supplier;
        this.imageUrl = imageUrl;
    }
}
