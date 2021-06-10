package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface EventDAL
{
    void saveEvent(Event event) throws Exception;
    List<Event> getEventsByNamesAndDates(String webSiteToken, String eventName, Timestamp dateFrom, Timestamp dateTo);
    List<String> getUniqueEventNames(String token) throws Exception;
    List<Event> findByDateAfter(Timestamp timestamp);
    List<Event> findById(String id, String token);
    void deleteEvent(Event event);
}
