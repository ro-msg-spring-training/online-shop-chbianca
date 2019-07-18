package ro.msg.learning.shop.dto;

import lombok.Data;
import ro.msg.learning.shop.entities.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

@Data
public class SimpleOrderDTO {

    private Customer customer;
    private LocalDateTime timestamp;
    private Address deliveryAddress;
    private List<SimpleProduct> products;

    public SimpleOrderDTO() {
    }

    public SimpleOrderDTO( LocalDateTime timestamp, Address deliveryAddress, List<SimpleProduct> products) {
        super();
        this.timestamp = timestamp;
        this.deliveryAddress = deliveryAddress;
        this.products = products;
    }

    public static SimpleOrderDTO SimpleOrderToDTO (SimpleOrder SimpleOrder){
        SimpleOrderDTO SimpleOrderDto = new SimpleOrderDTO.SimpleOrderBuilder()
                .with($ -> {
                    $.nestedTimestamp = SimpleOrder.getTimestamp();
                    $.nestedDeliveryAddress = SimpleOrder.getDeliveryAddress();
                    $.nestedProducts = SimpleOrder.getProducts();
                })
                .createSimpleOrder();
        return SimpleOrderDto;
    }

    public static SimpleOrder dtoToSimpleOrder (SimpleOrderDTO SimpleOrderDTO) {
        SimpleOrder SimpleOrder = new SimpleOrder();
        SimpleOrder.setTimestamp(SimpleOrderDTO.getTimestamp());
        SimpleOrder.setDeliveryAddress(SimpleOrderDTO.getDeliveryAddress());
        return SimpleOrder;
    }

    public static class SimpleOrderBuilder {
        public Integer nestedId;
        public LocalDateTime nestedTimestamp;
        public Address nestedDeliveryAddress;
        public List<SimpleProduct> nestedProducts;

        public SimpleOrderBuilder with(
                Consumer<SimpleOrderBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public SimpleOrderDTO createSimpleOrder() {
            return new SimpleOrderDTO(nestedTimestamp, nestedDeliveryAddress, nestedProducts);
        }
    }

}