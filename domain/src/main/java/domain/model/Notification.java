package domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Модель уведомления
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "notification")
public class Notification {
    /**
     * id уведомления
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    /**
     * текст уведомления
     */
    @Column(name = "text")
    private String text;

    @Column(name = "created")
    private LocalDateTime created = LocalDateTime.now();

}
