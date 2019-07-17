package ro.msg.learning.shop.entities;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Location extends BaseEntity {
    @Column(name = "name")
    String name;

    @Embedded
    Address address;

}
