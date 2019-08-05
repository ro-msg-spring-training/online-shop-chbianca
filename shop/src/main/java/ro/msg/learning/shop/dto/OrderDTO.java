package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ro.msg.learning.shop.auxiliar_entities.Address;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Order;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class OrderDTO {

    private Integer id;
    private Location shippedFrom;
    private Customer customer;
    private LocalDateTime createdAt;
    private Address address;

    public static OrderDTO orderToDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .address(order.getAddress())
                .customer(order.getCustomer())
                .createdAt(order.getCreatedAt())
                .address(order.getAddress())
                .build();
    }
}