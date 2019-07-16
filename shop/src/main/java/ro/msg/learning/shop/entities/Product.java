package ro.msg.learning.shop.entities;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class Product extends BaseEntity {
    String Name;
    String Description;
    BigDecimal Price;
    Double Weight;
    @ManyToOne
    ProductCategory Category;
    @ManyToOne
    Supplier Supplier;
    String ImageUrl;

    /*
    @OneToMany(mappedBy = "Product")
    Set<Stock> stoks;

    @OneToMany(mappedBy = "Product")
    Set<OrderDetail> orderDetails;

     */
}
