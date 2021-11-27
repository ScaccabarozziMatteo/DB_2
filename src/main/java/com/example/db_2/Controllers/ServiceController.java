package com.example.db_2.Controllers;

import com.example.db_2.POJO.Service;
import com.example.db_2.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value="/getmobilephone")
    public List<Service> getMobilePhone()
    {
        return serviceService.findMobilePhone();
    }

    @GetMapping(value="/getmobileinternet")
    public List<Service> getMobileInternet()
    {
        return serviceService.findMobileInternet();
    }

    @GetMapping(value="/getfixedinternet")
    public List<Service> getFixedInternet()
    {
        return serviceService.findFixedInternet();
    }

}
