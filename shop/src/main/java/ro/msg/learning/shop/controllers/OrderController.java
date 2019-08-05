package ro.msg.learning.shop.controllers;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimpleOrderDTO;
import ro.msg.learning.shop.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public OrderDTO createOrder(@RequestBody SimpleOrderDTO simpleOrderDTO) {
        return orderService.createOrder(simpleOrderDTO);
    }
}
