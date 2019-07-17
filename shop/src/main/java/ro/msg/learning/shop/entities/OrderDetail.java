package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OrderDetail {

    @EmbeddedId //mark the primary key
    OrderDetailKey id;

    @ManyToOne
    @MapsId("orderr")
    @JoinColumn(name = "orderr")
    Orderr orderr;

    @ManyToOne
    @MapsId("product")
    @JoinColumn(name = "product")
    Product product;

    Integer quantity;
}
