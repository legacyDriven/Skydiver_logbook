package pl.skydive.logbook.skydiver_logbook.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.skydive.logbook.skydiver_logbook.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}


