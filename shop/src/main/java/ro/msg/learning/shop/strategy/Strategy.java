package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.auxiliar_entities.Item;
import ro.msg.learning.shop.auxiliar_entities.SimpleProduct;

import java.util.List;

public interface Strategy {
    List<Item> findLocations(List<SimpleProduct> products);
}
