package com.example.db_2.Controllers;

import com.example.db_2.POJO.Package;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/package")
public class PackageController {

    private PackageService PS;

    @Autowired
    public PackageController(PackageService packageService){
        this.PS = packageService;
    }

    @GetMapping(value = "/getall")
    public List<Package> getAllPackages()
    {
        return PS.findALL();
    }

    @PostMapping(value = "/create")
    public int createPackage(HttpServletResponse response, @RequestParam String name, @RequestParam Float fee12, @RequestParam Float fee24, @RequestParam Float fee36, @RequestParam int employee_id, @RequestParam List<Integer> services_id, @RequestParam List<Integer> prods_id) throws IOException {
        Integer i=null;
        try {
            i= PS.createPackage(name, fee12, fee24, fee36, employee_id, services_id, prods_id);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED,e.getMessage());
        }

        return i;
    }

}
