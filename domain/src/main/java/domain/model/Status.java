package src.main.java.domain.model;

import lombok.*;

/**
 * модель статуса заказа
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Status {
    /**
     * id статуса
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * название статуса
     */
    private String status;
}
