package domain.model;

import lombok.*;

/**
 * модель бонусной карты
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Card {
    /**
     * id карты
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * номер карты
     */
    private int number;

    /**
     * пользователь
     */
    private Customer customer;

    /**
     * бонусы
     */
    private int bonusPoints;

}
