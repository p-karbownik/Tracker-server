package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatRequestDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;
import pl.edu.pw.pik.pikactivitytrackerserver.service.EventService;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins="*")
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

    @PostMapping(value = "/getStatisticsPerDay")
    public ResponseEntity<?> getStatisticsDataPerDay(@RequestBody StatRequestDTO requestDTO)
    {
        StatisticsDTO stats = eventService.getStatisticsPerDay(requestDTO);
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @PostMapping(value = "/getStatisticsPerHour")
    public ResponseEntity<?> getStatisticsDataPerHour(@RequestBody StatRequestDTO requestDTO)
    {
        StatisticsDTO stats = eventService.getStatisticsPerHour(requestDTO);
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping(value = "/getEventsNames/{websiteToken}")
    public ResponseEntity<?> getEventNames(@PathVariable String websiteToken)
    {
        List<String> list = eventService.getEventsNames(websiteToken);

        if(list == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


}
