package domain.model;

import lombok.*;

import javax.persistence.*;

/**
 * модель продукта
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table
public class Product {
    /**
     * id продукта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private int id;

    /**
     * название продукта
     */
    @Column(name = "name")
    private String name;

}
