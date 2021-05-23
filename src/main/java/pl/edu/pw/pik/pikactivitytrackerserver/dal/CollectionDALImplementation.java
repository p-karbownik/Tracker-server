package pl.edu.pw.pik.pikactivitytrackerserver.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class CollectionDALImplementation implements CollectionDAL{
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CollectionDALImplementation(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createCollection(String collectionName) throws Exception {

        if(!mongoTemplate.getCollectionNames().contains(collectionName))
            mongoTemplate.createCollection(collectionName);
        else
            throw new Exception("Collection exists");
    }

    @Override
    public void dropCollection(String collectionName) {
        if(mongoTemplate.getCollectionNames().contains(collectionName))
            mongoTemplate.dropCollection(collectionName);
    }
}
