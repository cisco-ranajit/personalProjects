package com.crudOperation.main.controllers;

import com.crudOperation.main.entity.EmployeeDAO;
import com.crudOperation.main.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable Long id){
        service.deleteEntity(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDAO> updateEntity(@PathVariable Long id, @RequestBody EmployeeDAO employeeDAO){
        try {
            EmployeeDAO updatedEntity = service.updateEntity(id, employeeDAO);
            return ResponseEntity.ok(updatedEntity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
