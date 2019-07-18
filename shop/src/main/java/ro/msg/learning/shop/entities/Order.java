package ro.msg.learning.shop.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="orderr")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shipped_from ")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "created_at ")
    private LocalDateTime createdAt ;

    @Embedded
    private Address address;
}
