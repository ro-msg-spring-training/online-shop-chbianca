package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table
public class Revenue extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "location")
    Location location;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "sum")
    BigDecimal sum;
}
