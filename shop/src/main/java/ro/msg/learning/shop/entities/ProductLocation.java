package ro.msg.learning.shop.entities;

import lombok.Data;

import java.util.List;

@Data
public class ProductLocation {
    private Product product;
    private List<Location> locations;
}
