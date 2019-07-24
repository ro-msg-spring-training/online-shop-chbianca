package ro.msg.learning.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.MostAbundant;
import ro.msg.learning.shop.strategy.SingleLocation;
import ro.msg.learning.shop.strategy.Strategy;


@Configuration
@PropertySource("application.properties")
public class StrategyConfig {
    @Value("${strategyValue}")
    private String strategy;

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ProductRepository productRepository;


    @Bean
    public Strategy strategy(){
        if("singleLocation".equals(strategy)){
            return new SingleLocation(stockRepository, locationRepository, productRepository);
        }
        else return new MostAbundant(stockRepository, productRepository);
    }
}

