package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class Location extends BaseEntity {
    String Name;
    String AddressCountry;
    String AddressCity;
    String AddressCounty;
    String AddressStreetAddress;
}
