package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.SimpleProduct;

import java.util.List;

public interface Strategy {
    List<Location> findLocations(List<SimpleProduct> products);
}
