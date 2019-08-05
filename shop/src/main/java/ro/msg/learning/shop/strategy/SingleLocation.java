package ro.msg.learning.shop.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.auxiliar_entities.Item;
import ro.msg.learning.shop.auxiliar_entities.SimpleProduct;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.exception.ObjectNotFoundException;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SingleLocation implements Strategy {

    private StockRepository stockRepository;
    private LocationRepository locationRepository;
    private ProductRepository productRepository;


    public SingleLocation(StockRepository stockRepository, LocationRepository locationRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Item> findLocations(List<SimpleProduct> simpleProducts) {
        List<Location> locations = locationRepository.findAll();
        List<Item> items = new ArrayList<>();
        HashMap<Product, List<Location>> productLocations = new HashMap<>();
        for (Location location : locations) {
            for (SimpleProduct simpleProduct : simpleProducts) {
                productLocations.put(productRepository.findById(simpleProduct.getProductId()).orElseThrow(ObjectNotFoundException::new), verifyLocationsForProduct(simpleProduct));
            }

            for (Map.Entry<Product, List<Location>> productLocationEntry : productLocations.entrySet()) {
                if (!(productLocationEntry.getValue().contains(location)))
                    throw new NoSuchElementException();
            }
            for (SimpleProduct simpleProduct : simpleProducts) {
                Item item = new Item();
                item.setLocation(location);
                item.setProduct(productRepository.findById(simpleProduct.getProductId()).orElseThrow(ObjectNotFoundException::new));
                item.setQuantity(simpleProduct.getQuantity());
                items.add(item);
            }
            break;
        }
        return items;
    }

    private List<Location> verifyLocationsForProduct(SimpleProduct simpleProduct) {
        List<Stock> stocks = stockRepository.findByProduct_Id(simpleProduct.getProductId()).orElseThrow(ObjectNotFoundException::new);
        return stocks.stream()
                .filter(stock -> stock.getQuantity() >= simpleProduct.getQuantity())
                .map(Stock::getLocation)
                .collect(Collectors.toList());
    }
}