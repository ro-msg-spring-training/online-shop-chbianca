package ro.msg.learning.shop.services;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.SimpleOrderDTO;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.OrderDetailRepository;
import ro.msg.learning.shop.repositories.OrderRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private ProductRepository productRepository;
    private Strategy strategy;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository, Strategy strategy) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.strategy = strategy;
    }

    public Order methodGetOrder(SimpleOrderDTO simpleOrderDTO){
        Order order = new Order();
        order.setCreatedAt(simpleOrderDTO.getTimestamp());
        order.setAddress(simpleOrderDTO.getDeliveryAddress());
        List<SimpleProduct> simpleProducts = simpleOrderDTO.getProducts();
        simpleProducts.forEach(product -> {
                        OrderDetailKey orderDetailKey = new OrderDetailKey();
                        orderDetailKey.setOrder(order.getId());
                        orderDetailKey.setProduct(productRepository.findById(product.getId()).get().getId());
                        OrderDetailKey odk = new OrderDetailKey();
                        odk.setProduct(product.getId());
                        odk.setOrder(order.getId());
                        OrderDetail od = new OrderDetail();
                        od.setId(orderDetailKey);
                        od.setQuantity(product.getQuantity());
                        od.setOrder(order);
                        od.setProduct(productRepository.findById(product.getId()).get());
                        orderRepository.save(order);
                        orderDetailRepository.save(od);
                    }
            );
        //Location location = new Location();
        //location = strategy.findLocations(simpleProducts).get(0);
        //System.out.println("LOCATION: " + location.getName());
        return order;
    }

    public List<Item> getItems(SimpleOrderDTO simpleOrderDTO) {
        List<Item> items = new ArrayList<>();


        return items;
    }

}
