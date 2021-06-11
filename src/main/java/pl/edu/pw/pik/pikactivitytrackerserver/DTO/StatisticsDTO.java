package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StatisticsDTO {

    private String eventName;
    private ArrayList<String> labels;
    private ArrayList<Integer> amountOfEvents;

}
