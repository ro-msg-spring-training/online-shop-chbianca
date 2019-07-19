package ro.msg.learning.shop.entities;


import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table
public class Stock implements Comparable<Stock> {
    @EmbeddedId
    private StockKey Id;

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

    @Override
    public int compareTo(Stock stockToCompare) {
        int compareQuantity=((Stock)stockToCompare).getQuantity();
        return compareQuantity-this.quantity;
    }

}
