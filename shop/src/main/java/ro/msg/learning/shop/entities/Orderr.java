package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class Orderr extends BaseEntity{
    @ManyToOne
    Location ShippedFrom;

    @ManyToOne
    Customer Customer;
    LocalDateTime CreatedAt;

    String AddressCountry;
    String AddressCity;
    String AddressCounty;
    String AddressStreetAddress;
}
