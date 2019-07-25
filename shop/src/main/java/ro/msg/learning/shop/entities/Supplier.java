package ro.msg.learning.shop.entities;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Supplier extends BaseEntity {

    @Column(name = "name")
    private String name;

}
