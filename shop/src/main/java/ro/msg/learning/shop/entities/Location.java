package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.auxiliar_entities.Address;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table
public class Location extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    public Location(Integer id, String name, Address address) {
        super(id);
        this.name = name;
        this.address = address;
    }
}
