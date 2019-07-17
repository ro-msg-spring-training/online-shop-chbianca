package ro.msg.learning.shop.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "orderr")
    Integer order;

    @Column(name = "product")
    Integer product;
}
