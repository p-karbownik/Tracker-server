package pl.edu.pw.pik.pikactivitytrackerserver.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;


public interface EventDAO extends JpaRepository<Event, Integer> {
}
