package ro.msg.learning.shop.auxiliar_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StockKey implements Serializable {
    @Column(name = "product")
    private Integer product;

    @Column(name = "location")
    private Integer location;
}

