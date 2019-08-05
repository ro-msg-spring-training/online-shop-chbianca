package ro.msg.learning.shop.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.msg.learning.shop.auxiliar_entities.OrderDetailKey;

import javax.persistence.*;

@EqualsAndHashCode(exclude = "product")
@Data
@Entity
@Table
public class OrderDetail {

    @EmbeddedId
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
