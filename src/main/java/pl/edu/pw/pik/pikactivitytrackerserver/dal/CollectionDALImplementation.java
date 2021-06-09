package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.exeptions.CollectionDoesNotExistException;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.util.List;

@Repository
public class CollectionDALImplementation implements CollectionDAL{
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CollectionDALImplementation(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createCollection(String collectionName) {
        mongoTemplate.createCollection(collectionName);
    }

    @Override
    public void dropCollection(String collectionName) {
        if(mongoTemplate.getCollectionNames().contains(collectionName))
            mongoTemplate.dropCollection(collectionName);
    }

    @Override
    public List<Event> getEventsFromCollection(String token) throws CollectionDoesNotExistException {
        if(mongoTemplate.getCollectionNames().contains(token)){
//            TODO create query
        }
        throw new CollectionDoesNotExistException(token);
    }
}
