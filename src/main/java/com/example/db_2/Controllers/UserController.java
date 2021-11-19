package com.example.db_2.Controllers;

import com.example.db_2.POJO.User;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService US;

    @Autowired
    public UserController(UserService userService){
        US=userService;
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody String email, @RequestBody String password, HttpServletResponse response) throws IOException {
        User u = new User();
        try {
             u = US.checkCredentials(email, password);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + e.getMessage());
        }
        return u;
    }

    @PostMapping(value ="/registration")
    public int registration( HttpServletResponse response, @RequestParam String username, @RequestParam String email,  @RequestParam String password) throws IOException {
        int i=-1;
        try {
            i=US.createUser(email, username, password);
            return i;
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_CONFLICT, "Registration Failed: " + e.getMessage());

        }
        return i;
    }



}
