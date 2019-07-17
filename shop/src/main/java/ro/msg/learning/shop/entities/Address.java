package ro.msg.learning.shop.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
@EqualsAndHashCode
@Getter
@Setter
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
