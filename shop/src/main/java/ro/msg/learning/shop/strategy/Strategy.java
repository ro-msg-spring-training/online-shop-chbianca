package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.entities.Item;
import ro.msg.learning.shop.entities.SimpleProduct;
import java.util.List;

public interface Strategy {
    public List<Item> findLocations(List<SimpleProduct> products);
}
