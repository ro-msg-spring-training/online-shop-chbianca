package ro.msg.learning.shop;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMigrations {
    @Bean(initMethod = "migrate")
    Flyway flyway(){
        return Flyway.configure().dataSource("jdbc:h2:~/test", "sa", null).load();
    }
}

