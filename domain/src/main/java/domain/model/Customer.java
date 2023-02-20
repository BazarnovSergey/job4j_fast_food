package src.main.java.domain.model;

import lombok.*;

/**
 * модель покупателя
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Customer {

    /**
     * id покупателя
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * имя покупателя
     */
    private String name;

    /**
     * фамилия покупателя
     */
    private String surname;

    /**
     * номер телефона покупателя
     */
    private String phone;

    /**
     * адрес покупателя
     */
    private Address address;

    /**
     * бонусная карта покупателя
     */
    private Card card;

    /**
     * заказ покупателя
     */
    private Order order;
}
