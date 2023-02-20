package src.main.java.domain.model;

import lombok.*;

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
public class Order {
    /**
     * id заказа
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * статус выполнения заказа
     */
    private Status status;

    /**
     * стоимость заказа
     */
    private int sum;

    /**
     * продукт
     */
    private Product product;

    /**
     * список блюд
     */
    private List<Dish> dishes = new ArrayList<>();

    /**
     * дата создания заказа
     */
    private LocalDateTime created = LocalDateTime.now();
}
