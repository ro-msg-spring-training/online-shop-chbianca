package ro.msg.learning.shop.controllers;

import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ProductDTO getProductById(@PathVariable("id") Integer id) {
        return productService.findProductById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertProduct(@RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int deleteProduct(@PathVariable("id") Integer id) {
        return productService.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public int updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO) {
        return productService.update(id,productDTO);
    }
}

