package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table
public class Location extends BaseEntity {
    @Column(name = "name")
    String name;

    @Embedded
    Address address;

    //@OneToMany(mappedBy = "Stock")
    //Set<Stock> stoks;

    // @OneToMany(mappedBy = "Location")
    //Set<Revenue> revenues;

    //@OneToMany(mappedBy = "Location")
    // Set<Orderr> orderr;
}
