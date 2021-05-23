package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.TokenDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.UserDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.WebsiteDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;
import pl.edu.pw.pik.pikactivitytrackerserver.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> addWebsite(@RequestBody UserDTO dto)
    {
        User user = userService.register(dto);

        if(user != null)
        {
            return new ResponseEntity<>(user.getUsername(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }
}
