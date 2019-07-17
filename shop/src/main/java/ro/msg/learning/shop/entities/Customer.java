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
public class Customer extends BaseEntity {
    @Column(name = "first_name")
    String first_name;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "email_address")
    String email_address ;
}
