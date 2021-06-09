package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    public List<Event> getEventsBetweenDatesGroupByDate(String webSiteToken, String eventName, LocalDateTime dateFrom, LocalDateTime dateTo)
    {
        if(mongoTemplate.getCollectionNames().contains(webSiteToken))
        {
            Criteria criteria = new Criteria().andOperator(
                    where("eventName").is(eventName),
                    where("eventTimestamp").gte(dateFrom),
                    where("eventTimestamp").lte(dateTo));

            ProjectionOperation dateProjection = project()
                    .and("eventName").as("eventName")
                    .and("eventTimestamp").extractYear().as("year")
                    .and("eventTimestamp").extractMonth().as("month")
                    .and("eventTimestamp").extractDayOfMonth().as("day");

            GroupOperation groupBy = group("year", "month", "day")
                    .count().as("eventsAmount");

            Aggregation agg = newAggregation(
                    match(criteria),
                    dateProjection,
                    groupBy,
                    sort(Sort.Direction.ASC, "year", "month", "day")
            );

            AggregationResults<StatisticsDTO> groupResults = mongoTemplate.aggregate(agg, webSiteToken, StatisticsDTO.class);

            return null;//return groupResults.toString();
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
