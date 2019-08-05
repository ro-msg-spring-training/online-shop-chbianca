package ro.msg.learning.shop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.CustomerDTO;
import ro.msg.learning.shop.services.UserDetailsService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserDetailsService userDetailsService;

    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CustomerDTO> getAllCustomers() {
        return userDetailsService.findAll();
    }

}