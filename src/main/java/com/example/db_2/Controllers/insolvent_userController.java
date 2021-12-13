package com.example.db_2.Controllers;

import com.example.db_2.POJO.insolvent_user;
import com.example.db_2.Services.insolvent_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/insolventreport")
public class insolvent_userController {
    private insolvent_userService IS;

    @Autowired
    public insolvent_userController(insolvent_userService iss){
        this.IS = iss;
    }

    @GetMapping(value = "/getAll")
    public List<insolvent_user> getAll(){
        return IS.getAll();
    }

}
