package ro.msg.learning.shop.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SingleLocation implements Strategy{

    private StockRepository stockRepository;
    private LocationRepository locationRepository;
    private ProductRepository productRepository;


    public SingleLocation(StockRepository stockRepository, LocationRepository locationRepository, ProductRepository productRepository){
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Item> findLocations(List<SimpleProduct> simpleProducts) {
        List<Location> locations = locationRepository.findAll();
        List<Item> items = new ArrayList<>();
        Set<ProductLocation> productLocations = new HashSet();
        for (Location location : locations) {
            boolean b = true;
            for (SimpleProduct simpleProduct : simpleProducts) {
                ProductLocation productLocation = new ProductLocation();
                productLocation.setProduct(productRepository.findById(simpleProduct.getId()).get());
                productLocation.setLocations(verifyLocationsForProduct(simpleProduct));
                productLocations.add(productLocation);
            }

            for (ProductLocation productLocation : productLocations) {
                if (!(productLocation.getLocations().contains(location))) {
                    b = false;
                }
            }

            if (b)
            {
                for (SimpleProduct simpleProduct : simpleProducts) {
                    Item item = new Item();
                    item.setLocation(location);
                    item.setProduct(productRepository.findById(simpleProduct.getId()).get());
                    item.setQuantity(simpleProduct.getQuantity());
                    items.add(item);
                }
                break;
            }
            else
            {System.out.println("Nu exista pe stoc toate produsele in aceeasi locatie!");}


        }
        return items;
    }


    public List<Location> verifyLocationsForProduct(SimpleProduct simpleProduct) {
        List<Stock> stocks = stockRepository.findAll();
        List<Location> locations = new ArrayList<>();
        for (Stock stock : stocks) {
            if ((simpleProduct.getId().equals(stock.getProduct().getId())) && (simpleProduct.getQuantity() <= stock.getQuantity())) {
                locations.add(stock.getLocation());
            }
        }
        return locations;
    }


}