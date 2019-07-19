package ro.msg.learning.shop.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SingleLocation implements Strategy{

    private StockRepository stockRepository;
    private LocationRepository locationRepository;

    public SingleLocation(StockRepository stockRepository, LocationRepository locationRepository){
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findLocations(List<SimpleProduct> simpleProducts) {
        //List<Location> locations = locationRepository.findAll();
        List<Location> finalLocations = new ArrayList<>();
        int i = 1;
        List<Location> locations = locationRepository.findAll();
        for(Location location: locations) {
            boolean b = true;
            for (SimpleProduct simpleProduct : simpleProducts) {
                if (!(verifyLocationsForProduct(simpleProduct).contains(location))) {
                    b = false;
                }
            }
            if (b) {
                finalLocations.add(location);
                break;
            }
        }
        return finalLocations;
    }


    public List<Location> verifyLocationsForProduct(SimpleProduct simpleProduct) {
        List<Location> locations = new ArrayList<>();
        List<Stock> stocks = stockRepository.findAll();
        for (Stock stock : stocks) {
            if ((simpleProduct.getId().equals(stock.getProduct().getId())) && (simpleProduct.getQuantity() <= stock.getQuantity())) {
                locations.add(stock.getLocation());
            }
        }
        return locations;
    }


}