package ro.msg.learning.shop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.*;
import ro.msg.learning.shop.services.ProductService;

import java.math.BigDecimal;

@RestController
public class TestController {
    private SupplierRepository sr;
    private ProductRepository pr;
    private CustomerRepository cr;
    private LocationRepository lr;
    private OrderRepository or;
    private OrderDetailRepository odr;
    private ProductCategoryRepository pcr;
    private RevenueRepository rr;
    private StockRepository srr;
    private ProductService ps;



    public TestController(SupplierRepository sr, ProductRepository pr, CustomerRepository cr, LocationRepository lr, OrderRepository or, OrderDetailRepository odr, ProductCategoryRepository pcr, RevenueRepository rr, StockRepository srr, ProductService ps){
        this.sr = sr;
        this.pr = pr;
        this.cr = cr;
        this.lr = lr;
        this.or = or;
        this.odr = odr;
        this.pcr = pcr;
        this.rr = rr;
        this.srr = srr;
        this.ps = ps;
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("TEST SUPPLIER: " + sr.findAll());
        System.out.println("TEST PRODUCT: " + pr.findAll());
        System.out.println("TEST CUSTOMER: " + cr.findAll());
        System.out.println("TEST LOCATION: " + lr.findAll());
        System.out.println("TEST ORDER: " + or.findAll());
        System.out.println("TEST ORDER_DETAIL: " + odr.findAll());
        System.out.println("TEST PRODUCT_CATEGORY: " + pcr.findAll());
        System.out.println("TEST REVENUE: " + rr.findAll());
        System.out.println("TEST STOCK: " + srr.findAll());
        System.out.println("TEST STOCK: " + srr.findAll());

        ProductCategory pc= pcr.findById(1).get();
        Supplier s = sr.findById(1).get();
        ProductDTO pd = new ProductDTO(2, "t", "t", new BigDecimal("103.81"), 25.0, pc , s, "-");
        //ProductDTO pd2 = new ProductDTO(2, "tt", "tt", new BigDecimal("103.81"), 25.0,pc , s, "--");
        System.out.println("TEST ProductService: " + ps.findProductById(1).getName() + "\n" + ps.findAll() + "\n" + ps.create(pd));
        //System.out.println("TEST ProductService: " + ps.delete(2)) ;

    }
}

