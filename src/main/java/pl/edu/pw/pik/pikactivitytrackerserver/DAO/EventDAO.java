package pl.edu.pw.pik.pikactivitytrackerserver.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.util.Optional;


public class EventDAO implements Dao<Event> {
    @Override
    public Optional<Event> get(Long id) {
        //TODO
        return Optional.empty();
    }

    @Override
    public void save(Event event) {
        //TODO
    }

    @Override
    public void update(Event event, String[] params) {
        //TODO
    }

    @Override
    public void delete(Event event) {
        //TODO
    }
}
