package pl.edu.pw.pik.pikactivitytrackerserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "website")
@Table(name = "websites")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Website{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "website_id")
    private int website_id;

    @Column(name = "website_name")
    private String name;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "token")
    private String token;

    @Column(name = "url")
    private String url;

}
