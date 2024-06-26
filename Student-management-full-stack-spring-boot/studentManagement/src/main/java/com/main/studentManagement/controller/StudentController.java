package com.main.studentManagement.controller;

import com.main.studentManagement.entity.StudentInfo;
import com.main.studentManagement.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    private StudentServiceImpl service;
    @GetMapping("/student/{studentId}")
    public StudentInfo getEntity(@PathVariable Long studentId){
        return service.getEntityById(studentId);
    }

    @GetMapping("/student")
    public List<StudentInfo> getEntityList(){
        return service.getEntityList();
    }

    @PostMapping("/student/create")
    public StudentInfo createEntity(@RequestBody StudentInfo studentInfo){
        return service.createEntity(studentInfo);
    }

}
