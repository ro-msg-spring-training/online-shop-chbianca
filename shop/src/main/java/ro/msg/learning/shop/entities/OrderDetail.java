package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class OrderDetail {

    @Id
    OrderDetailId Id;
    Integer Quantity;
}
