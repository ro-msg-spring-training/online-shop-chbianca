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
public class Customer extends BaseEntity {
    String firstName;
    String lastName;
    String username;
    String password;
    String emailAddress;
}
