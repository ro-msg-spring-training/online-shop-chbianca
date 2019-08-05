package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
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

    public Revenue(Integer id, Location location, LocalDate date, BigDecimal sum) {
        super(id);
        this.location = location;
        this.date = date;
        this.sum = sum;
    }
}
