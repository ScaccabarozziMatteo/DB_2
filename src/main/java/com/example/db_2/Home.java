package com.example.db_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;

@RestController
@RequestMapping("/Home")
public class Home {

    @GetMapping
    public String helloWorld()
    {
        return "Hello World!";
    }

}