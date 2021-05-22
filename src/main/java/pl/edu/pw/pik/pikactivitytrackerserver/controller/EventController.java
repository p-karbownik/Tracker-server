package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

@RestController
@RequestMapping("/events")
public class EventController {

    @PostMapping(value = "/new_event")
    public ResponseEntity<String> newEvent(@RequestBody EventDTO dto)
    {
        return new ResponseEntity<>("Lubie placki z wisniami", HttpStatus.OK);
    }
}
