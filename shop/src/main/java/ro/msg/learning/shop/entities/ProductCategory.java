package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table
public class ProductCategory extends BaseEntity {
    String name;
    String description;
}
