package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class StockKey implements Serializable {
    @Column(name = "product")
    Integer product;

    @Column(name = "location")
    Integer location;
}

