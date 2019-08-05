package ro.msg.learning.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.auxiliar_entities.Item;
import ro.msg.learning.shop.auxiliar_entities.OrderDetailKey;
import ro.msg.learning.shop.auxiliar_entities.SimpleProduct;
import ro.msg.learning.shop.auxiliar_entities.StockKey;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimpleOrderDTO;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.entities.OrderDetail;
import ro.msg.learning.shop.exception.ObjectNotFoundException;
import ro.msg.learning.shop.repositories.OrderDetailRepository;
import ro.msg.learning.shop.repositories.OrderRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private ProductRepository productRepository;
    private StockRepository stockRepository;
    private Strategy strategy;

    public OrderDTO createOrder(SimpleOrderDTO simpleOrderDTO) {
        Order order = new Order();
        order.setCreatedAt(simpleOrderDTO.getTimestamp());
        order.setAddress(simpleOrderDTO.getDeliveryAddress());
        List<SimpleProduct> simpleProducts = simpleOrderDTO.getProducts();
        if (checkProducts(simpleProducts)) {
            orderRepository.save(order);
            simpleProducts.forEach(simpleProduct -> {
                OrderDetailKey odk = new OrderDetailKey();
                OrderDetail od = new OrderDetail();
                OrderDetailKey orderDetailKey = new OrderDetailKey();
                orderDetailKey.setOrder(order.getId());
                orderDetailKey.setProduct(productRepository.findById(simpleProduct.getProductId()).orElseThrow(ObjectNotFoundException::new).getId());
                odk.setProduct(simpleProduct.getProductId());
                odk.setOrder(order.getId());
                od.setId(orderDetailKey);
                od.setQuantity(simpleProduct.getQuantity());
                od.setOrder(orderRepository.findById(order.getId()).orElseThrow(ObjectNotFoundException::new));
                od.setProduct(productRepository.findById(simpleProduct.getProductId()).orElseThrow(ObjectNotFoundException::new));
                orderDetailRepository.save(od);
            });
            updateStocks(simpleOrderDTO);
        }
        return OrderDTO.orderToDTO(order);
    }

    private void updateStocks(SimpleOrderDTO simpleOrderDTO) {
        List<Item> items = new ArrayList<>();
        try {
            items = strategy.findLocations(simpleOrderDTO.getProducts());
        } catch (ObjectNotFoundException e) {
            e.getMessage();
        }
        for (Item item : items) {
            StockKey stockKey = new StockKey();
            stockKey.setLocation(item.getLocation().getId());
            stockKey.setProduct(item.getProduct().getId());
            Integer quantity = stockRepository.getOne(stockKey).getQuantity();
            stockRepository.updateStockById(quantity - item.getQuantity(), stockKey);
        }
    }

    private Boolean checkProducts(List<SimpleProduct> simpleProducts) {
        return simpleProducts.stream().map(simpleProduct -> productRepository.findById(simpleProduct.getProductId()).
                isPresent()).reduce(true, (identity, obj) -> identity && obj);
    }

}
