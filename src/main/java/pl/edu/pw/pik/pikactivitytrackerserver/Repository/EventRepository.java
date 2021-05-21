package pl.edu.pw.pik.pikactivitytrackerserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;


public interface EventRepository extends JpaRepository<Event, Long> {

}
