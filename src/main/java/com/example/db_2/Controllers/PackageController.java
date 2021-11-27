package com.example.db_2.Controllers;

import com.example.db_2.POJO.OptionalProduct;
import com.example.db_2.POJO.Package;
import com.example.db_2.POJO.Service;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
    public int createPackage(HttpServletResponse response,@RequestBody Package aPackage) throws IOException {
        Integer i=null;
        List<Integer> services_id = new ArrayList<>();
        List<Integer> prods_id = new ArrayList<>();

        for(Service aService : aPackage.getServices()){
            services_id.add(aService.getId()) ;
        }

        if(aPackage.getOptionalProducts()!=null) {
            for (OptionalProduct opp : aPackage.getOptionalProducts()) {
                prods_id.add(opp.getId());
            }
        }

        try {
            i= PS.createPackage(aPackage.getName(), aPackage.getFee12(), aPackage.getFee24(), aPackage.getFee36(),aPackage.getEmployee().getId(), services_id, prods_id);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED,e.getMessage());
        }

        return i;
    }

}
