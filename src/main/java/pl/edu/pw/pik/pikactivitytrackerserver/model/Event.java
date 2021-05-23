package pl.edu.pw.pik.pikactivitytrackerserver.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

//@Document
public class Event {

    @Id
    private String id;
    private String website_token;
    private String eventName;
    private String eventData;

    public Event()
    {
    }

    public Event(String id, String website_token, String eventData) {
        this.id = id;
        this.website_token = website_token;
        this.eventData = eventData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsite_token() {
        return website_token;
    }

    public void setWebsite_token(String website_token) {
        this.website_token = website_token;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


}
