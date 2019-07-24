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

    public SimpleOrderDTO( LocalDateTime timestamp, Address deliveryAddress, List<SimpleProduct> products) {
        super();
        this.timestamp = timestamp;
        this.deliveryAddress = deliveryAddress;
        this.products = products;
    }

    public static SimpleOrderDTO simpleOrderToDTO (SimpleOrder simpleOrder){
        SimpleOrderDTO simpleOrderDTO = new SimpleOrderDTO.SimpleOrderBuilder()
                .with($ -> {
                    $.nestedTimestamp = simpleOrder.getTimestamp();
                    $.nestedDeliveryAddress = simpleOrder.getDeliveryAddress();
                    $.nestedProducts = simpleOrder.getProducts();
                })
                .createSimpleOrder();
        return simpleOrderDTO;
    }

    public static SimpleOrder dtoToSimpleOrder (SimpleOrderDTO simpleOrderDTO) {
        SimpleOrder simpleOrder = new SimpleOrder();
        simpleOrder.setTimestamp(simpleOrderDTO.getTimestamp());
        simpleOrder.setDeliveryAddress(simpleOrderDTO.getDeliveryAddress());
        return simpleOrder;
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