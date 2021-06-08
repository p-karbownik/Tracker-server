package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.MainDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;
import pl.edu.pw.pik.pikactivitytrackerserver.service.WebsiteService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins="*")
public class MainController {

    @Autowired
    WebsiteService websiteService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<MainDTO>> getMainData(@PathVariable int userId)
    {
        List<Website> websites = websiteService.getWebsitesByUserId(userId);
        List<MainDTO> result = new ArrayList<>();

        for(Website website : websites){
            int websiteId = website.getWebsite_id();
            String websiteName = website.getName();
            int numberOfEvents = 0;
            Timestamp lastEventTimestamp = null;
            String mostPopularEventName = null;



            MainDTO mainDTO = new MainDTO(websiteId, websiteName,
            numberOfEvents,
            lastEventTimestamp,
            mostPopularEventName);
        }

        return null;
    }
}
