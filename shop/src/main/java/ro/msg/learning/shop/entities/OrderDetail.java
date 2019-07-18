package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table
public class OrderDetail {

    @EmbeddedId //mark the primary key
    private OrderDetailKey id;

    @ManyToOne
    @MapsId("order")
    @JoinColumn(name = "orderr")
    private Order order;

    @ManyToOne
    @MapsId("product")
    @JoinColumn(name = "product")
    private Product product;

    private Integer quantity;
}
