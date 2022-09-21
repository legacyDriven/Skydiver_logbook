package pl.skydive.logbook.skydiver_logbook.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.skydive.logbook.skydiver_logbook.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAsLogin(Long aLong);
}


