package domain.model;

import lombok.*;

/**
 * Модель описывает адресс доставки
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Address {
    /**
     * id адреса доставки
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * город
     */
    private String city;

    /**
     * улица
     */
    private String street;

    /**
     * здание
     */
    private String building;
}
