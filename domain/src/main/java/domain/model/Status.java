package domain.model;

import lombok.*;

import javax.persistence.*;

/**
 * модель статуса заказа
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "status")
public class Status {
    /**
     * id статуса
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    /**
     * название статуса
     */
    @Column(name = "text")
    private String status;
}
