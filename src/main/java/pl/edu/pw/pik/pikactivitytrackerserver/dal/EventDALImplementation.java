package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Repository
public class EventDALImplementation implements EventDAL{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public EventDALImplementation(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveEvent(Event event) throws Exception {
        Set<String> collectionNames = mongoTemplate.getCollectionNames();

        if(collectionNames.contains(event.getWebsite_token()))
            mongoTemplate.save(event, event.getWebsite_token());
        else
            throw new Exception("The website is not supported");
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
