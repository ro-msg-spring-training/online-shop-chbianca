package ro.msg.learning.shop.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class StockId {
    @ManyToOne
    @JoinColumn(name = "Product")
    Product Product;

    @ManyToOne
    @JoinColumn(name = "Location")
    Location Location;
}
