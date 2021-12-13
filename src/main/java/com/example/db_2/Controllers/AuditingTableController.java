package com.example.db_2.Controllers;


import com.example.db_2.POJO.auditingTable;
import com.example.db_2.Services.AuditingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/auditingTable")
public class AuditingTableController {

    private AuditingTableService AS;

    @Autowired
    public AuditingTableController(AuditingTableService aas){
        this.AS = aas;
    }

    @GetMapping(value = "/getAll")
    public List<auditingTable> getAll(){
        return AS.getAuditingTable();
    }
}
