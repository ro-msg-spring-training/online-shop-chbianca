package ro.msg.learning.shop.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.entities.Item;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.SimpleProduct;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class MostAbundant implements Strategy{

    private StockRepository stockRepository;
    private LocationRepository locationRepository;
    private ProductRepository productRepository;

    public MostAbundant(StockRepository stockRepository, LocationRepository locationRepository, ProductRepository productRepository){
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Item> findLocations(List<SimpleProduct> simpleProducts) {
        List<Location> finalLocations = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        for (SimpleProduct simpleProduct : simpleProducts) {
            finalLocations.add(verifyLocationsWithMaxStockForProduct(simpleProduct));
            Item item = new Item();
            item.setLocation(verifyLocationsWithMaxStockForProduct(simpleProduct));
            item.setProduct(productRepository.findById(simpleProduct.getId()).get());
            item.setQuantity(simpleProduct.getQuantity());
            items.add(item);
        }
        return items;
    }

    public Location verifyLocationsWithMaxStockForProduct(SimpleProduct simpleProduct) {
        List<Stock> stocks = stockRepository.findAll();
        List<Stock> finalStocks = new ArrayList<>();
        for (Stock stock : stocks) {
            if ((simpleProduct.getId().equals(stock.getProduct().getId())) && (simpleProduct.getQuantity() <= stock.getQuantity())) {
                finalStocks.add(stock);
            }
        }
        Collections.sort(finalStocks);
        Location location = new Location();
        try{
            location = finalStocks.get(0).getLocation();
        }
        catch(Exception e)
        {
            System.out.println("Nu exista pe stoc 0!");
        }
        return location;
    }
}
