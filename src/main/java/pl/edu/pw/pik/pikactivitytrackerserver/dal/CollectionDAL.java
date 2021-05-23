package pl.edu.pw.pik.pikactivitytrackerserver.dal;

public interface CollectionDAL {
    public void createCollection(String collectionName) throws Exception;
    public void dropCollection(String collectionName);
}
