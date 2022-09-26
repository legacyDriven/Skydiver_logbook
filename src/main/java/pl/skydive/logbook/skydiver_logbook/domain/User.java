package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @NonNull
    @Column(name = "FIRSTNAME", length = 30)
    private String firstName;

    @NonNull
    @Column(name = "LASTNAME", length = 30)
    private String lastName;

    @NonNull
    @Column(name = "LOGIN", unique = true, updatable = false, length = 100) //nullable = false
    private String emailAsLogin;

    @Column(name = "ACCOUNT_CREATED")
    private LocalDateTime accountCreated;

    @Column(name = "LOGGED_SKYDIVES")
    @OneToMany(fetch = FetchType.EAGER)//check error logs for lazy fetchtype
    @ToString.Exclude
    private List<JumpLog> loggedSkydives;

    public User(Long id, @NonNull String firstName, @NonNull String lastName,
                @NonNull String emailAsLogin, LocalDateTime accountCreated, List<JumpLog> loggedSkydives) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAsLogin = emailAsLogin;
        this.accountCreated = accountCreated;
        this.loggedSkydives = loggedSkydives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName)
                && emailAsLogin.equals(user.emailAsLogin) && Objects.equals(accountCreated, user.accountCreated)
                && Objects.equals(loggedSkydives, user.loggedSkydives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, emailAsLogin, accountCreated, loggedSkydives);
    }
}
