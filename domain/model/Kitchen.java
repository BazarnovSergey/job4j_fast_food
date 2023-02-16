package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель кухни
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Kitchen {
    /**
     * id кухни
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * название кухни
     */
    private int name;

    /**
     * список заказов
     */
    private List<Order> orders = new ArrayList<>();

}
