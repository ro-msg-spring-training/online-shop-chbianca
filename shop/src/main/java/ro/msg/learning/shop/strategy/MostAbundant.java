package ro.msg.learning.shop.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.SimpleProduct;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class MostAbundant implements Strategy{

    private StockRepository stockRepository;
    private LocationRepository locationRepository;

    public MostAbundant(StockRepository stockRepository, LocationRepository locationRepository){
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findLocations(List<SimpleProduct> simpleProducts) {
        List<Location> finalLocations = new ArrayList<>();
            for (SimpleProduct simpleProduct : simpleProducts) {
                finalLocations.add(verifyLocationsWithMaxStockForProduct(simpleProduct));
            }
        return finalLocations;
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
        System.out.println("sss");
        return finalStocks.get(0).getLocation();
    }
}
