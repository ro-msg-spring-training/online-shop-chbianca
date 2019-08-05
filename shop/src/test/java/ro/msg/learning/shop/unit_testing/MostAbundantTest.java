package ro.msg.learning.shop.unit_testing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.msg.learning.shop.auxiliar_entities.Address;
import ro.msg.learning.shop.auxiliar_entities.Item;
import ro.msg.learning.shop.auxiliar_entities.SimpleProduct;
import ro.msg.learning.shop.auxiliar_entities.StockKey;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.MostAbundant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MostAbundantTest {
    @Mock
    private StockRepository stockRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private MostAbundant mostAbundant;

    @Before
    public void initMostAbundant() {
        mostAbundant = new MostAbundant(stockRepository, productRepository);
        ProductCategory pc1 = new ProductCategory(1, "telefon", "-");
        ProductCategory pc2 = new ProductCategory(2, "electrocasnice", "--");

        Supplier s1 = new Supplier(1, "S1");
        Supplier s2 = new Supplier(2, "S2");

        Address a1 = new Address("Romania", "Cluj", "Cluj", "George Baritiu");
        Address a2 = new Address("Romania", "Oradea", "Oradea", "Ana Ipatescu");

        Location l1 = new Location(1, "L1", a1);
        Location l2 = new Location(2, "L2", a2);

        Product p1 = new Product(1, "-", "Lenovo", new BigDecimal(2000), 2d, pc1, s1, "-");
        Product p2 = new Product(2, "--", "Philips", new BigDecimal(1000), 1d, pc2, s2, "--");

        StockKey sk1 = new StockKey(1, 1);
        StockKey sk2 = new StockKey(1, 2);

        Stock st1 = new Stock(sk1, p1, l1, 4);
        Stock st2 = new Stock(sk2, p2, l2, 6);

        List<Stock> stocks = new ArrayList<>();
        stocks.add(st1);
        stocks.add(st2);

        when(productRepository.findById(1)).thenReturn(Optional.of(p1));
        when(productRepository.findById(2)).thenReturn(Optional.of(p2));
        when(stockRepository.findAll()).thenReturn(stocks);
    }

    @Test
    public void findLocations() {
        List<SimpleProduct> simpleProducts = new ArrayList<>();
        SimpleProduct sp1 = new SimpleProduct(1, 2);
        SimpleProduct sp2 = new SimpleProduct(2, 2);
        simpleProducts.add(sp1);
        simpleProducts.add(sp2);

        List<Item> items = mostAbundant.findLocations(simpleProducts);
        assertThat(items.get(1)).isNotNull();
    }
}


