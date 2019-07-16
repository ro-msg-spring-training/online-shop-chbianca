package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.Entity;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class Customer extends BaseEntity {
    String FirstName;
    String LastName;
    String Username;
    String Password;
    String EmailAddress;
}
