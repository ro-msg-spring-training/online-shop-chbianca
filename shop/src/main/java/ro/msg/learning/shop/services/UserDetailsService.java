package ro.msg.learning.shop.services;

import org.springframework.stereotype.Service;

import ro.msg.learning.shop.dto.CustomerDTO;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.repositories.CustomerRepository;

import java.util.*;

@Service
public class UserDetailsService {

    private CustomerRepository customerRepository;

    public UserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO findCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return CustomerDTO.customerToDTO(customer);
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> toReturn = new ArrayList<CustomerDTO>();
        customers.forEach(Customer -> {
            toReturn.add(CustomerDTO.customerToDTO(Customer));
        });
        return toReturn;
    }


    public int create(CustomerDTO CustomerDTO) {
        Customer customer = new Customer();
        try {
            customer = customerRepository.save(CustomerDTO.dtoToCustomer(CustomerDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer.getId();
    }

    public Integer delete(Integer id) {
        customerRepository.deleteById(id);
        return id;
    }

    public Integer update(Integer id, CustomerDTO CustomerDTO) {
        customerRepository.deleteById(id);
        return create(CustomerDTO);
    }

    public Map<String, String> getUsernamesAndPasswords(){
        Map<String, String> accounts = new HashMap<String, String>();
        findAll().forEach(customer -> {
            accounts.put(customer.getUsername(), customer.getPassword());
        });
        return accounts;
    }
}
