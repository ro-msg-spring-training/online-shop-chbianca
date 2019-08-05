package ro.msg.learning.shop.services;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.CustomerDTO;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDetailsService {

    private CustomerRepository customerRepository;

    public UserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> toReturn = new ArrayList<>();
        customers.forEach(Customer -> toReturn.add(CustomerDTO.customerToDTO(Customer)));
        return toReturn;
    }

    public Map<String, String> getUsernamesAndPasswords() {
        Map<String, String> accounts = new HashMap<>();
        findAll().forEach(customer -> accounts.put(customer.getUsername(), customer.getPassword()));
        return accounts;
    }
}
