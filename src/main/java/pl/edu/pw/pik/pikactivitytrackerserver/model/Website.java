package pl.edu.pw.pik.pikactivitytrackerserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "website")
@Table(name = "websites")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Website{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "website_id")
    private int website_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "url")
    private String url;

}
