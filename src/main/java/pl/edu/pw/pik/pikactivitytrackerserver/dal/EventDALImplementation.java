package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.sql.Timestamp;
import java.util.Date;
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
    public void saveEvent(Event event) throws Exception {
        if(mongoTemplate.getCollectionNames().contains(event.getWebsite_token()))
            mongoTemplate.save(event, event.getWebsite_token());
        else
            throw new Exception("The website is not supported");
    }

    public List<Event> getEventsBetweenDates(String webSiteToken, String eventName, Date dateFrom, Date dateTo)
    {
        if(mongoTemplate.getCollectionNames().contains(webSiteToken))
        {
            Query query = new Query();
            Criteria criteria = Criteria.where("eventName").is(eventName);
            query.addCriteria(criteria);
            criteria = Criteria.where("eventTimestamp").lt(dateTo).gt(dateFrom);
            query.addCriteria(criteria);
            Event event = new Event();
            return mongoTemplate.find(query, Event.class, webSiteToken );
            //find(Query query, Class<T> entityClass, String collectionName)
            //Map the results of an ad-hoc query on the specified collection to a List of the specified type.
        }
        else
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
