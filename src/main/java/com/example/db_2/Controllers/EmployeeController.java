package com.example.db_2.Controllers;


import com.example.db_2.POJO.Employee;
import com.example.db_2.POJO.User;
import com.example.db_2.Services.EmployeeService;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private EmployeeService ES;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.ES = employeeService;
    }

   /* @GetMapping(value = "/get1")
    public Employee getdemo ()
    {
        return ES.findById(1);
    }*/

    @PostMapping(value = "/login")
    public Employee login(@RequestBody Map<String, String> parameters, HttpServletResponse response) throws IOException {
        String email = parameters.get("email");
        String password = parameters.get("password");

        Employee e = new Employee();
        try {
            e = ES.checkCredentials(email, password);
            if(e == null)
                response.sendError(HttpServletResponse.SC_CONFLICT, "Authentication Failed: " + email + " not registered!");
        } catch (MessageException m) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + m.getMessage());
        }
        return e;
    }

    @PostMapping(value ="/registration")
    public int registration(HttpServletResponse response,  @RequestParam String email,  @RequestParam String password) throws IOException {
        int i=-1;
        try {
            i=ES.createEmployee(email, password);
            return i;
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_CONFLICT, "Registration Failed: " + e.getMessage());

        }
        return i;
    }

}
