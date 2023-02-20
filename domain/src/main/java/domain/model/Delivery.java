package src.main.java.domain.model;

import lombok.*;

/**
 * Модель доставки
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Delivery {
    /**
     * id доставки
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * заказ
     */
    private Order order;


}
