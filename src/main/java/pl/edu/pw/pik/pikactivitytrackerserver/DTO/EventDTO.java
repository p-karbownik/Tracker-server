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
    private int id;
    private String websiteToken;
    private Timestamp appearanceDate;
    private String eventData;
}
