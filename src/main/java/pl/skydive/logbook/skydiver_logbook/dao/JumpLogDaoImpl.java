package pl.skydive.logbook.skydiver_logbook.dao;

import pl.skydive.logbook.skydiver_logbook.domain.JumpLog;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JumpLogDaoImpl implements JumpLogDao<JumpLog> {

    private EntityManager entityManager;

    @Override
    public Optional<JumpLog> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<JumpLog> getAll() {
        return null;
    }

    @Override
    public void save(JumpLog jumpLog) {

    }

    @Override
    public void update(JumpLog jumpLog, String[] params) {

    }

    @Override
    public void delete(JumpLog jumpLog) {

    }
}
