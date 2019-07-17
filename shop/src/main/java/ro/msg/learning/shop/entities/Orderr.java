package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table
public class Orderr extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "shipped_from ")
    Location shipped_from;

    @ManyToOne
    @JoinColumn(name = "customer")
    Customer customer;

    @Column(name = "created_at ")
    LocalDateTime created_at ;

    @Embedded
    Address address;

    //@OneToMany(mappedBy = "Orderr")
    // Set<OrderDetail> orderDetails;
}
