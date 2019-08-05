package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table
public class Supplier extends BaseEntity {

    @Column(name = "name")
    private String name;

    public Supplier(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
