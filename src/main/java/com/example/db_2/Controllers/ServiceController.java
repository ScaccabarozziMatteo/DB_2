package com.example.db_2.Controllers;

import com.example.db_2.POJO.Service;
import com.example.db_2.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/service")
public class ServiceController {

    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService ss){
        this.serviceService=ss;
    }

    @PostMapping(value = "/create")
    public int createNew(@RequestBody Service service){
       return serviceService.createNew(service);
    }

}
