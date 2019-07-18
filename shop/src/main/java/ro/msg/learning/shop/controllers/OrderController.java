package ro.msg.learning.shop.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimpleOrderDTO;
import ro.msg.learning.shop.services.OrderService;

@RestController
@RequestMapping("/simpleOrder")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertSimpleOrder(@RequestBody SimpleOrderDTO simpleOrderDTO) {
        return orderService.methodGetOrder(simpleOrderDTO).getId();
    }
}
