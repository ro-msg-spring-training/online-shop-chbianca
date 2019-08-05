package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.auxiliar_entities.StockKey;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
        int compareQuantity = stockToCompare.getQuantity();
        return compareQuantity - this.quantity;
    }
}
