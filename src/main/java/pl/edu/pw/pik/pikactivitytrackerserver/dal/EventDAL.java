package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.sql.Timestamp;
import java.util.List;

public interface EventDAL
{
    Event saveEvent(Event event);
    List<Event> getAllEventOfWebsite(String token);
    List<Event> findByDateAfter(Timestamp timestamp);
    List<Event> findById(String id, String token);
    void deleteEvent(Event event);
}
