package src.main.java.domain.model;

import lombok.*;

/**
 * Модель блюда
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Dish {

    /**
     * id блюда
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * название блюда
     */
    private String name;

    /**
     * описание блюда
     */
    private String description;

    /**
     * калорийность блюда
     */
    private int calories;

    /**
     * цена блюда
     */
    private int price;
}
