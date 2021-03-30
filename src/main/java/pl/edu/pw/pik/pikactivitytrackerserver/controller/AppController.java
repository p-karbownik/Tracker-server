package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path")
public class AppController {

    @GetMapping("/message")
    public String getString(){
        return "PIK";
    }
}
