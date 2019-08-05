package ro.msg.learning.shop.auxiliar_entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleProduct {
    private Integer productId;
    private Integer quantity;
}