package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

@RestController
@RequestMapping("/events")
public class EventController {

    @PostMapping(value = "new_event")
    public void newEvent(@RequestBody Event event)
    {

    }
}
