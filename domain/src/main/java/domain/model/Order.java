package domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель заказа
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "my_order")
public class Order {
    /**
     * id заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    /**
     * статус выполнения заказа
     */

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    /**
     * стоимость заказа
     */
    @Column(name = "sum")
    private int sum;

    /**
     * продукт
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * список блюд
     */
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Dish> dishes = new ArrayList<>();

    /**
     * дата создания заказа
     */
    @Column(name = "created")
    private LocalDateTime created = LocalDateTime.now();
}
