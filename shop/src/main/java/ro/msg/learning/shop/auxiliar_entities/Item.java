package ro.msg.learning.shop.auxiliar_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Location location;
    private Product product;
    private Integer quantity;
}
