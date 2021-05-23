package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class EventDALImplementation implements EventDAL{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public EventDALImplementation(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Event saveEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> getAllEventOfWebsite(String token) {
        return null;
    }

    @Override
    public List<Event> findByDateAfter(Timestamp timestamp) {
        return null;
    }

    @Override
    public List<Event> findById(String id, String token) {
        return null;
    }

    @Override
    public void deleteEvent(Event event) {

    }
}
