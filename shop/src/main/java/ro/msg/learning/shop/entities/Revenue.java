package ro.msg.learning.shop.entities;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Revenue extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "sum")
    private BigDecimal sum;
}
