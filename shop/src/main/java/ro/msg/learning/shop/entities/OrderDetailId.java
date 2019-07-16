package ro.msg.learning.shop.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderDetailId {
    @ManyToOne
    @JoinColumn(name = "Orderr")
    Orderr order;

    @ManyToOne
    @JoinColumn(name = "Product")
    Product Product;
}
