package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainDTO {
    private  int websiteId;
    private String websiteName;
    private String token;
    private int numberOfEvents;
    private Timestamp lastEventTimestamp;
    private String mostPopularEventName;
}
