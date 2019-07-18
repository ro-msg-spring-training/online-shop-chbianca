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
    private Product product;

    @ManyToOne
    @MapsId("location")
    @JoinColumn(name = "location")
    private Location location;

    @Column(name = "quantity")
    private Integer quantity;
}
