package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EventDTO
{
    private String websiteToken;
    private String eventName;
    private Timestamp appearanceDate;
    private String eventData;
}
