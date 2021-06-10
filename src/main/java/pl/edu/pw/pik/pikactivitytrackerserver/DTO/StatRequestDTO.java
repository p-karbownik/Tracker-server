package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatRequestDTO {
    private String webToken;
    private String eventName;
    private Timestamp dateFrom;
    private Timestamp dateTo;
}
