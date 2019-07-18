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
    private OrderDetailKey id;

    @ManyToOne
    @MapsId("orderr")
    @JoinColumn(name = "orderr")
    private Orderr orderr;

    @ManyToOne
    @MapsId("product")
    @JoinColumn(name = "product")
    private Product product;

    private Integer quantity;
}
