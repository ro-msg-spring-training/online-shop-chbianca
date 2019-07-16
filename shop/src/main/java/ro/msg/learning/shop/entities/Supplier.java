package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.Entity;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class Supplier extends BaseEntity {
    String Name;
}
