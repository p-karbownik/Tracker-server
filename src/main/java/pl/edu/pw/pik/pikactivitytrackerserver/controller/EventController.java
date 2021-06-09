package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.service.EventService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping(value = "/new_event")
    public ResponseEntity<?> newEvent(@RequestBody EventDTO dto)
    {
        if(eventService.saveEvent(dto))
            return new ResponseEntity<>(null, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/getStatistics/{webToken}/{eventName}/{statisticsPerDay}/{dateFrom}/{dateTo}")
    public ResponseEntity<StatisticsDTO> getStatisticsData(@PathVariable String webToken, @PathVariable String eventName, @PathVariable boolean statisticsPerDay,
                                           @PathVariable Date dateFrom, @PathVariable Date dateTo)
    {

        return null;
    }

    @GetMapping(value = "/getEventsNames/{websiteToken}")
    public ResponseEntity<List<String>> getEventNames(@PathVariable String websiteToken)
    {
        try
        {
            return new ResponseEntity<>(eventService.getEventNames(websiteToken), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
