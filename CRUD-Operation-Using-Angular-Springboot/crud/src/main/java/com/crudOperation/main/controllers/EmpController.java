package com.crudOperation.main.controllers;

import com.crudOperation.main.entity.EmployeeDAO;
import com.crudOperation.main.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/employees")
public class EmpController {
    @Autowired
    private EmployeService service;

    @GetMapping()
    public List<EmployeeDAO> getEntityList(){
        return service.getEntityList();
    }

    @PostMapping("/add")
    public EmployeeDAO createEntity(@RequestBody EmployeeDAO employeeDAO){
        return service.createEntity(employeeDAO);
    }

}
