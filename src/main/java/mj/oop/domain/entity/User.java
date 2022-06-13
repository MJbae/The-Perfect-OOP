package mj.oop.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * '사용자'에 대한 최상위 엔티티
 * <p>
 * All Known Extending Classes:
 *
 * @see Customer
 * </p>
 */
@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String password;

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
