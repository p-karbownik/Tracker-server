package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import pl.edu.pw.pik.pikactivitytrackerserver.exeptions.CollectionDoesNotExistException;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.util.List;

public interface CollectionDAL {
    public void createCollection(String collectionName);
    public void dropCollection(String collectionName);

    List<Event> getEventsFromCollection(String token) throws CollectionDoesNotExistException;
}
