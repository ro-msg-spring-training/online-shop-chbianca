package ro.msg.learning.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.MostAbundant;
import ro.msg.learning.shop.strategy.SingleLocation;
import ro.msg.learning.shop.strategy.Strategy;


@Configuration
public class StrategyConfig {
    @Value("${strategyValue}")
    private String strategy;

    private StockRepository stockRepository;
    private LocationRepository locationRepository;
    private ProductRepository productRepository;

    public StrategyConfig(StockRepository stockRepository, LocationRepository locationRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
    }

    @Bean
    public Strategy strategy() {
        if ("singleLocation".equals(strategy)) {
            return new SingleLocation(stockRepository, locationRepository, productRepository);
        } else return new MostAbundant(stockRepository, productRepository);
    }
}

