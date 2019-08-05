package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ro.msg.learning.shop.entities.Customer;

@Data
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;

    public static CustomerDTO customerToDTO(Customer customer) {
        return CustomerDTO.builder().id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .username(customer.getUsername())
                .password(customer.getUsername())
                .emailAddress(customer.getEmailAddress())
                .build();
    }
}