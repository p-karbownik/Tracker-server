package pl.edu.pw.pik.pikactivitytrackerserver.dal;

public interface CollectionDAL {
    public void createCollection(String collectionName);
    public void dropCollection(String collectionName);
}
