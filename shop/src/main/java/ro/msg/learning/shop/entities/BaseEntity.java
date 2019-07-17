package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode

public abstract class BaseEntity {

    @Id
    @GeneratedValue
    Integer id;
}
