package ro.msg.learning.shop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.repositories.*;

@RestController
public class TestController {
        private SupplierRepository sr;
        private ProductRepository pr;
        private CustomerRepository cr;
        private LocationRepository lr;
        private OrderrRepository or;
        private OrderDetailRepository odr;
        private ProductCategoryRepository pcr;
        private RevenueRepository rr;
        private StockRepository srr;


        public TestController(SupplierRepository sr, ProductRepository pr, CustomerRepository cr, LocationRepository lr, OrderrRepository or, OrderDetailRepository odr, ProductCategoryRepository pcr, RevenueRepository rr, StockRepository srr){
            this.sr = sr;
            this.pr = pr;
            this.cr = cr;
            this.lr = lr;
            this.or = or;
            this.odr = odr;
            this.pcr = pcr;
            this.rr = rr;
            this.srr = srr;
        }

    @RequestMapping("/test")
     public void test(){
            System.out.println("TEST SUPPLIER: " + sr.findAll());
            System.out.println("TEST PRODUCT: " + pr.findAll());
            System.out.println("TEST CUSTOMER: " + cr.findAll());
            System.out.println("TEST LOCATION: " + lr.findAll());
            System.out.println("TEST ORDERR: " + or.findAll());
            System.out.println("TEST ORDERR_DETAIL: " + odr.findAll());
            System.out.println("TEST PRODUCT_CATEGORY: " + pcr.findAll());
            System.out.println("TEST REVENUE: " + rr.findAll());
            System.out.println("TEST STOCK: " + srr.findAll());
     }
    }

