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
@EqualsAndHashCode
@Table
public class Product extends BaseEntity {
    String name;
    String description;
    BigDecimal price;
    Double weight;
    @ManyToOne
    ProductCategory category;
    @ManyToOne
    Supplier supplier;
    String imageUrl;

    @OneToMany(mappedBy = "product")
    Set<Stock> stoks;

    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetails;
}
