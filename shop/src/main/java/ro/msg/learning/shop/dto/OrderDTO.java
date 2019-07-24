package ro.msg.learning.shop.dto;

import lombok.Data;
import ro.msg.learning.shop.entities.*;
import java.time.LocalDateTime;
import java.util.function.Consumer;

@Data
public class OrderDTO {

    private Integer id;
    private Location shippedFrom;
    private Customer customer;
    private LocalDateTime createdAt;
    private Address address;

    public OrderDTO(Integer id, Location shippedFrom, Customer customer, LocalDateTime createdAt, Address address) {
        super();
        this.id = id;
        this.shippedFrom= shippedFrom;
        this.customer= customer;
        this.createdAt = createdAt;
        this.address = address;
    }

    public static OrderDTO OrderToDTO (Order Order){
        OrderDTO OrderDto = new OrderDTO.OrderBuilder()
                .with($ -> {
                    $.nestedId = Order.getId();
                    $.nestedSShippedFrom = Order.getShippedFrom();
                    $.nestedCustomer = Order.getCustomer();
                    $.nestedCreatedAt = Order.getCreatedAt();
                    $.nestedAddress = Order.getAddress();
                })
                .createOrder();
        return OrderDto;
    }

    public static Order dtoToOrder (OrderDTO OrderDTO) {
        Order Order = new Order();
        Order.setId(OrderDTO.getId());
        Order.setShippedFrom(OrderDTO.getShippedFrom());
        Order.setCustomer(OrderDTO.getCustomer());
        Order.setCreatedAt(OrderDTO.getCreatedAt());
        Order.setAddress(OrderDTO.getAddress());
        return Order;
    }

    public static class OrderBuilder {
        public Integer nestedId;
        public Location nestedSShippedFrom;
        public Customer nestedCustomer;
        public LocalDateTime nestedCreatedAt;
        public Address nestedAddress;

        public OrderBuilder with(
                Consumer<OrderBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public OrderDTO createOrder() {
            return new OrderDTO(nestedId, nestedSShippedFrom, nestedCustomer, nestedCreatedAt, nestedAddress);
        }
    }

}