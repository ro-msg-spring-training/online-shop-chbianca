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
public class Stock {
    @Id
    StockId Id;
    Integer Quantity;
}
