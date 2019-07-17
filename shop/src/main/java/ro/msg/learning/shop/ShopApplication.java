package ro.msg.learning.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import ro.msg.learning.shop.repositories.SupplierRepository;

@SpringBootApplication
//@EnableJpaRepositories(value = "ro.msg.learning.shop", repositoryFactoryBeanClass = SupplierRepository.class)
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
