package pl.edu.pw.pik.pikactivitytrackerserver.model;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;
//TODO how to use hibernate for non sql?

public class Event {
    private UUID website_token;
    private List<String> eventFields;
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
