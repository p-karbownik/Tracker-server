package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;
import pl.edu.pw.pik.pikactivitytrackerserver.service.EventService;
import pl.edu.pw.pik.pikactivitytrackerserver.service.WebsiteService;

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
}
