package com.example.db_2.Controllers;

import com.example.db_2.POJO.Package;
import com.example.db_2.POJO.Service;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/service")
public class ServiceController {

    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService ss){
        this.serviceService=ss;
    }


    @GetMapping(value = "/getall")
    public List<Service> getAllServices()
    {
        return serviceService.findAllServices();
    }

    @PostMapping(value = "/create")
    public int createNew(@RequestBody Service service, HttpServletResponse response) throws IOException {
        int r = -1;
        try {
            r = serviceService.createNew(service);
        } catch (MessageException e) {
            // e.printStackTrace();
            response.sendError(HttpServletResponse.SC_CONFLICT, e.getMessage());
        }
        return r;
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

