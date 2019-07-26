package ro.msg.learning.shop.services;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimpleOrderDTO;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.OrderDetailRepository;
import ro.msg.learning.shop.repositories.OrderRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private ProductRepository productRepository;
    private StockRepository stockRepository;
    private Strategy strategy;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository, StockRepository stockRepository, Strategy strategy) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.strategy = strategy;
    }

    public OrderDTO methodGetOrder(SimpleOrderDTO simpleOrderDTO) {
        Order order = new Order();
        order.setCreatedAt(simpleOrderDTO.getTimestamp());
        order.setAddress(simpleOrderDTO.getDeliveryAddress());
        List<SimpleProduct> simpleProducts = simpleOrderDTO.getProducts();
        OrderDetailKey odk = new OrderDetailKey();
        OrderDetail od = new OrderDetail();
        OrderDetailKey orderDetailKey = new OrderDetailKey();
        orderDetailKey.setOrder(order.getId());
        if (checkProducts(simpleProducts)) {
            orderRepository.save(order);
            try {
                simpleProducts.forEach(simpleProduct -> {
                    orderDetailKey.setProduct(productRepository.findById(simpleProduct.getProductId()).get().getId());
                    odk.setProduct(simpleProduct.getProductId());
                    odk.setOrder(order.getId());
                    od.setId(orderDetailKey);
                    od.setQuantity(simpleProduct.getQuantity());
                    od.setOrder(orderRepository.findById(order.getId()).get());
                    od.setProduct(productRepository.findById(simpleProduct.getProductId()).get());
                    orderDetailRepository.save(od);
                });
                updateStocks(simpleOrderDTO);
            } catch (NoSuchElementException e) {
                System.out.println("Produs inexistent!");
            } catch (Exception e) {
                System.out.println("Nu exista pe stoc!");
            }
        }
        return OrderDTO.orderToDTO(order);
    }

    public void updateStocks(SimpleOrderDTO simpleOrderDTO) {
        List<Item> items = new ArrayList<>();
        items = strategy.findLocations(simpleOrderDTO.getProducts());
        for (Item item : items) {
            StockKey stockKey = new StockKey();
            stockKey.setLocation(item.getLocation().getId());
            stockKey.setProduct(item.getProduct().getId());
            Integer quantity = stockRepository.getOne(stockKey).getQuantity();
            stockRepository.deleteById(stockKey);
            Stock stock = new Stock();
            stock.setId(stockKey);
            stock.setQuantity(quantity - item.getQuantity());
            stock.setLocation(item.getLocation());
            stock.setProduct(item.getProduct());
            stockRepository.save(stock);
        }
    }

    public Boolean checkProducts(List<SimpleProduct> simpleProducts) {
        Boolean b = true;
        for (SimpleProduct simpleProduct : simpleProducts) {
            try {
                 productRepository.findById(simpleProduct.getProductId()).get();
            } catch (NoSuchElementException e) {
                b = false;
                System.out.println(e.getMessage());
            }
        }
        return b;
    }
}
