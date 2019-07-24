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

    public static OrderDTO OrderToDTO (Order order){
        OrderDTO orderDto = new OrderDTO.OrderBuilder()
                .with($ -> {
                    $.nestedId = order.getId();
                    $.nestedSShippedFrom = order.getShippedFrom();
                    $.nestedCustomer = order.getCustomer();
                    $.nestedCreatedAt = order.getCreatedAt();
                    $.nestedAddress = order.getAddress();
                })
                .createOrder();
        return orderDto;
    }

    public static Order dtoToOrder (OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setShippedFrom(orderDTO.getShippedFrom());
        order.setCustomer(orderDTO.getCustomer());
        order.setCreatedAt(orderDTO.getCreatedAt());
        order.setAddress(orderDTO.getAddress());
        return order;
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