package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainDTO {
    int websiteId;
    String websiteName;
    int numberOfEvents;
    Timestamp lastEventTimestamp;
    String mostPopularEventName;
}
