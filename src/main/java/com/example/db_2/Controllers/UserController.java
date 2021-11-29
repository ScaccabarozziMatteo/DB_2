package com.example.db_2.Controllers;

import com.example.db_2.POJO.Order;
import com.example.db_2.POJO.User;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService US;

    @Autowired
    public UserController(UserService userService){
        US=userService;
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user, HttpServletResponse response) throws IOException {
        User u = new User();

        try {
             u = US.checkCredentials(user.getEmail(),user.getPassword());
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + e.getMessage());
        }
        return u;
    }

    @PostMapping(value ="/registration")
    public int registration( HttpServletResponse response,@RequestBody User user) throws IOException {
        int i=-1;
        try {
            i=US.createUser(user.getEmail(), user.getUsername(), user.getPassword());
            return i;
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_CONFLICT, "Registration Failed: " + e.getMessage());

        }
        return i;
    }

    @GetMapping(value = "/getorders")
    public List<Order> getAllforUser (@RequestParam int user_id, HttpServletResponse response) throws IOException {
        List<Order> orders = new ArrayList<>();
        try {
            orders = US.getUserOrders(user_id);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Impossible to retrive orders for user" + user_id + ": " + e.getMessage());
        }
        return orders;
    }

@GetMapping(value = "/getinsolvent")
    public Integer getInsolvent(@RequestParam int user_id,HttpServletResponse response) throws IOException {
        Integer i =null;

    try {
        i=US.getInsolvent(user_id);
    } catch (MessageException e) {
        //e.printStackTrace();
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
    }
    return i;
}

@GetMapping(value = "/getAllUserInsolvents")
    public List<User> getAllInsolvents() {
        return US.getAllInsolvents();
    }

}
