package ro.msg.learning.shop.entities;


import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Stock {
    @EmbeddedId
    StockKey Id;

    @ManyToOne
    @MapsId("Product")
    @JoinColumn(name = "product")
    Product product;

    @ManyToOne
    @MapsId("location")
    @JoinColumn(name = "location")
    Location location;

    @Column(name = "quantity")
    Integer quantity;
}
