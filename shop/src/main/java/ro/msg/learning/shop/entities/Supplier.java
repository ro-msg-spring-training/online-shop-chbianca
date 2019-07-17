package ro.msg.learning.shop.entities;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Supplier extends BaseEntity {

    @Column(name = "name")
    String name;
}
