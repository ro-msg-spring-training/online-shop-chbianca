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
public class Orderr extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "shippedFrom")
    Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customer")
    Customer customer;
    LocalDateTime createdAt;

    @Embedded
    Address address;

    //@OneToMany(mappedBy = "Orderr")
    // Set<OrderDetail> orderDetails;
}
