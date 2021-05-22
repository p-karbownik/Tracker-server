package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.pw.pik.pikactivitytrackerserver.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/register/{login}/{password}")
    public boolean register(@PathVariable String login, @PathVariable String password) {
        if(userService.loginExists(login)){
            return false;
        } else {
            return userService.register(login, password);
        }
    }
}
