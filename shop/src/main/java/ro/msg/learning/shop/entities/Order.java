package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.auxiliar_entities.Address;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderr")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shipped_from ")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "created_at ")
    private LocalDateTime createdAt;

    @Embedded
    private Address address;
}
