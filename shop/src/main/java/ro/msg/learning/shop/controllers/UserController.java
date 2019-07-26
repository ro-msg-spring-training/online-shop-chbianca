package ro.msg.learning.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.CustomerDTO;
import ro.msg.learning.shop.services.UserDetailsService;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CustomerDTO> getAllCustomers() {
        return userDetailsService.findAll();
    }

}