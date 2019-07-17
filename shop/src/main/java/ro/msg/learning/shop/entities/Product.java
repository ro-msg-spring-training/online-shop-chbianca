package ro.msg.learning.shop.entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product extends BaseEntity {
    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "weight")
    Double weight;

    @ManyToOne
    //@Column(name = "category_id")
    ProductCategory category ;

    @ManyToOne
    //@Column(name = "supplier_id")
    Supplier supplier;

    @Column(name = "image_url")
    String image_url;

    @OneToMany(mappedBy = "product")
    Set<Stock> stoks;

    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetails;
}
