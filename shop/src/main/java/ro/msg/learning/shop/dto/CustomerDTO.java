package ro.msg.learning.shop.dto;

import lombok.Data;
import ro.msg.learning.shop.entities.Customer;
import java.util.function.Consumer;

@Data
public class CustomerDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;


    public CustomerDTO(Integer id, String firstName, String lastName, String username, String password, String emailAddress) {
        super();
        this.id = id;
        this.firstName= firstName;
        this.lastName= lastName;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public static CustomerDTO customerToDTO (Customer customer){
        CustomerDTO customerDto = new CustomerDTO.CustomerBuilder()
                .with($ -> {
                    $.nestedId = customer.getId();
                    $.nestedFirstName = customer.getFirstName();
                    $.nestedLastName = customer.getLastName();
                    $.nestedUsername = customer.getUsername();
                    $.nestedPassword = customer.getPassword();
                    $.nestedEmailAddress = customer.getEmailAddress();
                })
                .createCustomer();
        return customerDto;
    }

    public static Customer dtoToCustomer (CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setUsername(customerDTO.getUsername());
        return customer;
    }

    public static class CustomerBuilder {
        public Integer nestedId;
        public String nestedFirstName;
        public String nestedLastName;
        public String nestedUsername;
        public String nestedPassword;
        public String nestedEmailAddress;

        public CustomerBuilder with(
                Consumer<CustomerBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public CustomerDTO createCustomer() {
            return new CustomerDTO(nestedId, nestedFirstName, nestedLastName, nestedUsername, nestedPassword, nestedEmailAddress);
        }
    }

}