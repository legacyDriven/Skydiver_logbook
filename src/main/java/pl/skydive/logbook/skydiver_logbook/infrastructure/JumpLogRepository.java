package pl.skydive.logbook.skydiver_logbook.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skydive.logbook.skydiver_logbook.domain.JumpLog;

import java.util.Optional;

@Repository
public interface JumpLogRepository extends JpaRepository<JumpLog, Long> {

    @Override
    Optional<JumpLog> findById(Long aLong);
}
