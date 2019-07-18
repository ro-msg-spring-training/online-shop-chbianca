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
    private String name;

    @Embedded
    private Address address;

}
