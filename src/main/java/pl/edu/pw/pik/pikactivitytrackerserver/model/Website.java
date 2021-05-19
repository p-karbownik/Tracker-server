package pl.edu.pw.pik.pikactivitytrackerserver.model;

import javax.persistence.*;

@Entity
@Table(name = "websites")
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private int user_id;

    //TODO Do I need id or is it actually generated
    public Website(String url, int user_id) {
        this.url = url;
        this.user_id = user_id;
    }

    //TODO why jpa requires an empty constructor?
    public Website() {

    }
}
