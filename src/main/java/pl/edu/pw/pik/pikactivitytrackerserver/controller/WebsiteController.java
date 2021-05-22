package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;
import pl.edu.pw.pik.pikactivitytrackerserver.service.WebsiteService;

import java.util.List;

@RestController
@RequestMapping(path="/websites")
@CrossOrigin(origins="*")

public class WebsiteController {

    @Autowired
    WebsiteService websiteService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Website> websiteById(@PathVariable Integer id)
    {
        System.out.println(id);
        Website w = websiteService.getSingleWebsite(1);
        if(w == null)
        {
            System.out.println("kuupa"
            );
        }
        if(w != null)
        {
            return new ResponseEntity<>(w, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
