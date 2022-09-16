package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "account_created")
    private LocalDateTime accountCreated;

    { accountCreated = LocalDateTime.now(); }

    public User(long l, String marek, String szparek, String s) {
    }
}
