package src.main.java.domain.model;

import lombok.*;

/**
 * модель продукта
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Product {
    /**
     * id продукта
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * название продукта
     */
    private String name;

}
