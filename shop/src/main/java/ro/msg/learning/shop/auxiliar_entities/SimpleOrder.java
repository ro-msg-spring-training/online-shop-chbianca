package ro.msg.learning.shop.auxiliar_entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SimpleOrder {
    private LocalDateTime timestamp;
    private Address deliveryAddress;
    private List<SimpleProduct> products;
}