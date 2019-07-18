package ro.msg.learning.shop.entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter @Setter
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
    private ProductCategory category ;

    @ManyToOne
    private Supplier supplier;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    private Set<Stock> stoks;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;
}
