package com.example.db_2.Controllers;

import com.example.db_2.POJO.OptionalProduct;
import com.example.db_2.Services.OptionalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/product")
public class OptionalProductController {
    private OptionalProductService optionalProductService;

    @Autowired
    public OptionalProductController(OptionalProductService op){
        this.optionalProductService = op;
    }

    @GetMapping(value ="/getall")
    public List<OptionalProduct> getall(){
        return optionalProductService.getAll();
    }

}
