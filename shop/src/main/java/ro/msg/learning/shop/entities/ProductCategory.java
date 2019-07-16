package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.Entity;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class ProductCategory extends BaseEntity {
    String Name;
    String Description;
}
