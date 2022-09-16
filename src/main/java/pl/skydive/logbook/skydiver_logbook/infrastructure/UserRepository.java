package pl.skydive.logbook.skydiver_logbook.infrastructure;

import pl.skydive.logbook.skydiver_logbook.domain.User;
import java.util.List;

public interface UserRepository {

    List<UserRepository> getAllUsers();

    User getUserById();

    void updateUser(User user);

}
