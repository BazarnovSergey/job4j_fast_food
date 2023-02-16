package model;

import lombok.*;

/**
 * Модель уведомления
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Notification {
    /**
     * id уведомления
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * текст уведомления
     */
    private String text;
}
