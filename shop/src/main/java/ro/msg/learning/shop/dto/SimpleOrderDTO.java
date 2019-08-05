package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ro.msg.learning.shop.auxiliar_entities.Address;
import ro.msg.learning.shop.auxiliar_entities.SimpleProduct;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SimpleOrderDTO {

    private LocalDateTime timestamp;
    private Address deliveryAddress;
    private List<SimpleProduct> products;
}