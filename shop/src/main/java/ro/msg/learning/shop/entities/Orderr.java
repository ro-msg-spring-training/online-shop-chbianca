package ro.msg.learning.shop.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
}
