package ro.msg.learning.shop.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Address implements Serializable{

    @Column(name = "country")
    String country;

    @Column(name = "city")
    String city;

    @Column(name = "county")
    String county;

    @Column(name = "street_address")
    String street_address;
}
