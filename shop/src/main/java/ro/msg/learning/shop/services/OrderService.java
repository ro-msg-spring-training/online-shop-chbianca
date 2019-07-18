package ro.msg.learning.shop.services;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.SimpleOrderDTO;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.OrderDetailRepository;
import ro.msg.learning.shop.repositories.OrderRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    OrderDetailRepository orderDetailRepository;
    ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
    }

    public Order methodGetOrder(SimpleOrderDTO simpleOrderDTO){
        Order order = new Order();
        order.setCreatedAt(simpleOrderDTO.getTimestamp());
        order.setAddress(simpleOrderDTO.getDeliveryAddress());
        orderRepository.save(order);
        List<SimpleProduct> products = simpleOrderDTO.getProducts();
        products.forEach( product -> {
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
            orderDetailRepository.save(od);
                }
        );
        return order;
    }



}
