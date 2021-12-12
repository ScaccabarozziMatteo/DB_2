package com.example.db_2.Controllers;

import com.example.db_2.POJO.ProductReport;
import com.example.db_2.Services.ProductReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/productreport")
public class ProductReportController {

    private ProductReportService PR;

    @Autowired
    public  ProductReportController(ProductReportService prr){
        this.PR = prr;
    }

    @GetMapping(value = "/getAll")
    public List<ProductReport> getAll(){
        return PR.getAll();
    }
}
