package com.crudOperation.main.controllers;

import com.crudOperation.main.entity.EmployeeDAO;
import com.crudOperation.main.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {
    @Autowired
    private EmployeService service;

    @GetMapping()
    public List<EmployeeDAO> getEntityList(){
        return service.getEntityList();
    }

}
