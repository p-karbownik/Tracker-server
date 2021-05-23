package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.TokenDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.WebsiteDTO;
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
        Website w = websiteService.getSingleWebsite(id);

        if(w != null)
        {
            return new ResponseEntity<>(w, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<Website>> getUsersWebsites(@PathVariable Integer id)
    {
        List<Website> lW = websiteService.getWebsitesByUserId(id);

        if(lW != null)
            return new ResponseEntity<>(lW, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addWebsite")
    public ResponseEntity<TokenDTO> addWebsite(@RequestBody WebsiteDTO dto)
    {
        String token = websiteService.addWebsite(dto);

        if(token != null)
        {
            return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/deleteWebsite/{user_id}/{website_id}")
    public void deleteWebsite(@PathVariable Integer user_id, @PathVariable Integer website_id)
    {
        websiteService.deleteWebsite(user_id, website_id);
    }

    @DeleteMapping("/deleteAll/{user_id}")
    public void deleteAllWebsitesByUserId(@PathVariable Integer user_id)
    {
        deleteAllWebsitesByUserId(user_id);
    }
}
