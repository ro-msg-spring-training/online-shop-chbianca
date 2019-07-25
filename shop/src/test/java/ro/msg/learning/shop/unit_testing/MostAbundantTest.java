package ro.msg.learning.shop.unit_testing;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
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

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class MostAbundantTest {
    @Mock
    private StockRepository stockRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private MostAbundant mostAbundant;

    @BeforeEach
    public void initMostAbundant() {
        mostAbundant = new MostAbundant(stockRepository, productRepository );
        ProductCategory pc1 = new ProductCategory();
        pc1.setId(1);
        pc1.setName("telefon");
        pc1.setDescription("-");

        ProductCategory pc2 = new ProductCategory();
        pc2.setId(2);
        pc2.setName("electrocasnice");
        pc2.setDescription("-");

        Supplier s1 = new Supplier();
        s1.setId(1);
        s1.setName("S1");
        Supplier s2 = new Supplier();
        s2.setId(2);
        s2.setName("S2");

        Address a1 = new Address();
        a1.setCountry("Romania");
        a1.setCity("Cluj");
        a1.setCounty("Cluj");
        a1.setStreetAddress("George Baritiu");
        Address a2 = new Address();
        a2.setCountry("Romania");
        a2.setCity("Oradea");
        a2.setCounty("Oradea");
        a2.setStreetAddress("Ana Ipatescu");

        Location l1 = new Location();
        l1.setId(1);
        l1.setName("L1");
        l1.setAddress(a1);
        Location l2 = new Location();
        l2.setId(2);
        l2.setName("L2");
        l2.setAddress(a2);

        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Lenovo");
        p1.setDescription("-");
        p1.setPrice(new BigDecimal(2000));
        p1.setWeight(new Double(2));
        p1.setCategory(pc1);
        p1.setSupplier(s1);
        p1.setImageUrl("");


        Product p2 = new Product();
        p2.setId(2);
        p2.setName("Philips");
        p2.setDescription("-");
        p2.setPrice(new BigDecimal(1000));
        p2.setWeight(new Double(1));
        p2.setCategory(pc2);
        p2.setSupplier(s2);
        p2.setImageUrl("");


        StockKey sk1 = new StockKey();
        sk1.setLocation(1);
        sk1.setProduct(1);


        StockKey sk2 = new StockKey();
        sk2.setLocation(1);
        sk2.setProduct(2);

        StockKey sk3 = new StockKey();
        sk1.setLocation(2);
        sk1.setProduct(1);


        StockKey sk4 = new StockKey();
        sk2.setLocation(2);
        sk2.setProduct(2);


        Stock st1 = new Stock();
        st1.setId(sk1);
        st1.setQuantity(4);

        Stock st2 = new Stock();
        st2.setId(sk2);
        st2.setQuantity(6);

        Stock st3 = new Stock();
        st1.setId(sk3);
        st1.setQuantity(8);

        Stock st4 = new Stock();
        st2.setId(sk4);
        st2.setQuantity(12);

        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        locations.add(l2);

        List<Stock> stocks = new ArrayList<>();
        stocks.add(st1);
        stocks.add(st2);
        stocks.add(st3);
        stocks.add(st4);

        SimpleProduct sp1 = new SimpleProduct();
        sp1.setProductId(1);
        sp1.setQuantity(3);

        SimpleProduct sp2 = new SimpleProduct();
        sp2.setProductId(2);
        sp2.setQuantity(3);

        Item i1 = new Item();
        i1.setProduct(p1);
        i1.setLocation(l2);
        i1.setQuantity(3);

        Item i2 = new Item();
        i2.setProduct(p2);
        i2.setLocation(l2);
        i2.setQuantity(3);

        when(productRepository.findById(1)).thenReturn(Optional.of(p1));
        //when(productRepository.findById(2)).thenReturn(Optional.of(p2));
        when(stockRepository.findAll()).thenReturn(stocks);
    }

    @Test
    public void findLocations() {
        List<SimpleProduct> simpleProducts = new ArrayList<>();
        SimpleProduct sp1 = new SimpleProduct();
        sp1.setProductId(1);
        sp1.setQuantity(3);

        SimpleProduct sp2 = new SimpleProduct();
        sp2.setProductId(2);
        sp2.setQuantity(3);
        simpleProducts.add(sp1);
        simpleProducts.add(sp2);

        List<Item> items = mostAbundant.findLocations(simpleProducts);
        assertThat(items.get(0)).isNotNull();
    }

}


