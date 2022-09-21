package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "USERS")
public class User {

    { accountCreated = LocalDateTime.now(); }

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
    @OneToMany(fetch = FetchType.LAZY)
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
}
