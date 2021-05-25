package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.TokenDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.UserDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.WebsiteDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;
import pl.edu.pw.pik.pikactivitytrackerserver.service.UserService;


@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO dto)
    {
        User user = userService.register(dto);

        if(user != null)
        {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }
}
