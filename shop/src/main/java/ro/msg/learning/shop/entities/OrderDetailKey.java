package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
@Data
@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "orderr")
    Integer order;

    @Column(name = "product")
    Integer product;
}
