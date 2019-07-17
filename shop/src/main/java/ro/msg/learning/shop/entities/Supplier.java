package ro.msg.learning.shop.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table
public class Supplier extends BaseEntity {

    @Column(name = "name")
    String name;
}
