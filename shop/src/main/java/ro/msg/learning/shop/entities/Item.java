package ro.msg.learning.shop.entities;

import lombok.Data;

@Data
public class Item {
    private Location location;
    private Product product;
    private Integer quantity;
}
