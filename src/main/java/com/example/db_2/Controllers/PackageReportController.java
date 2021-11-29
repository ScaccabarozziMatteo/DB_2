package com.example.db_2.Controllers;

import com.example.db_2.POJO.Package_Report;
import com.example.db_2.Services.MessageException;
import com.example.db_2.Services.PackageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController(value="/packreport")
public class PackageReportController {
    private PackageReportService packageReportService;

    @Autowired
    public PackageReportController(PackageReportService prs){
        this.packageReportService = prs;
    }

    @GetMapping(value="/getAll")
    public List<Package_Report> getAll(){
        return packageReportService.getAll();
    }

    @GetMapping(value="/package")
    public  Package_Report getPackageReport(@RequestParam int aPackage, HttpServletResponse response) throws IOException {
        Package_Report pr = new Package_Report();
        try {
            pr = packageReportService.getByPackage(aPackage);
        } catch (MessageException e) {
            //e.printStackTrace();
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return pr;
    }

}
