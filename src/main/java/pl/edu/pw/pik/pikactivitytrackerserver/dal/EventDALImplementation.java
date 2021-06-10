package pl.edu.pw.pik.pikactivitytrackerserver.dal;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;
import java.sql.Timestamp;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

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

    @Override
    public List<Event> getEventsByNamesAndDates(String webSiteToken, String eventName, Timestamp dateFrom, Timestamp dateTo)
    {
        if(mongoTemplate.getCollectionNames().contains(webSiteToken))
        {
            Query query = new Query();

            Criteria criteria = new Criteria().andOperator(
                    where("eventName").is(eventName),
                    where("eventOccurrenceLocalDateTime").lte(dateTo),
                    where("eventOccurrenceLocalDateTime").gte(dateFrom)
            );

            query.addCriteria(criteria);

            return mongoTemplate.find(query, Event.class, webSiteToken);
        }
        else
            return null;

    }

    @Override
    public List<String> getUniqueEventNames(String token) throws Exception
    {
        if(mongoTemplate.getCollectionNames().contains(token))
        {
            Query query = new Query();
            List<String> list = mongoTemplate.findDistinct(query, "eventName", token, Event.class, String.class);

            return list;
        }
        else
            throw new Exception("The website is not supported");
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
