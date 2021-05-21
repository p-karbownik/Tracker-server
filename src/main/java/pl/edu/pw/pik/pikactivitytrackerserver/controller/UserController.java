package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pw.pik.pikactivitytrackerserver.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;
}
