package pl.skydive.logbook.skydiver_logbook.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skydive.logbook.skydiver_logbook.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

/*

public interface UserRepository {

    List<UserRepository> getAllUsers();

    User getUserById();

    void updateUser(User user);

}

 */