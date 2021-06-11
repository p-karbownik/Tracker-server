package pl.edu.pw.pik.pikactivitytrackerserver.exeptions;

public class CollectionDoesNotExistException extends Exception{
    public CollectionDoesNotExistException(String token) {
        super("Collection: " + token + " does not exist");
    }
}
