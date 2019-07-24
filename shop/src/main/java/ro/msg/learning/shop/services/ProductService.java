package ro.msg.learning.shop.services;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO findProductById(Integer productId) {
        Product product = productRepository.findById(productId).get();
        return ProductDTO.productToDTO(product);
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> toReturn = new ArrayList<ProductDTO>();
        products.forEach(product -> {
            toReturn.add(ProductDTO.productToDTO(product));
        });
        return toReturn;
    }


    public int create(ProductDTO productDTO) {
        Product product = new Product();
        try {
            product = productRepository.save(ProductDTO.dtoToProduct(productDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product.getId();
    }

    public Integer delete(Integer id) {
        productRepository.deleteById(id);
        return id;
    }

    public Integer update(Integer id, ProductDTO productDTO) {
        productRepository.deleteById(id);
        return create(productDTO);
    }



}
