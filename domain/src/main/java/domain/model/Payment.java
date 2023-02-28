package domain.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * модель платежа
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Payment {

    /**
     * id платежа
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * дата платежа
     */
    private LocalDateTime create = LocalDateTime.now();
}
