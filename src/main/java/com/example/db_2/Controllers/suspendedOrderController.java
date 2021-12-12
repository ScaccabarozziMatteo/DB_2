package com.example.db_2.Controllers;

import com.example.db_2.POJO.suspendedOrder;
import com.example.db_2.Services.suspendedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/suspendedorder")
public class suspendedOrderController {
    private suspendedOrderService OS;

    @Autowired
    public suspendedOrderController(suspendedOrderService OSS){
        this.OS = OSS;
    }

    @GetMapping(value = "/getAll")
    public List<suspendedOrder> getAll(){
        return OS.getAll();
    }

}
