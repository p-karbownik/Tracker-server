package pl.edu.pw.pik.pikactivitytrackerserver.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

@Repository
public interface EventRepository //extends// MongoRepository<Event, String>
{

}