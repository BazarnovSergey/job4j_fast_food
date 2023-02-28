package domain.model;

import lombok.*;

import javax.persistence.*;

/**
 * Модель блюда
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "dish")
public class Dish {

    /**
     * id блюда
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private int id;

    /**
     * название блюда
     */
    @Column(name = "name")
    private String name;

    /**
     * описание блюда
     */
    @Column(name = "description")
    private String description;

    /**
     * калорийность блюда
     */
    @Column(name = "calories")
    private int calories;

    /**
     * цена блюда
     */
    @Column(name = "price")
    private int price;
}
