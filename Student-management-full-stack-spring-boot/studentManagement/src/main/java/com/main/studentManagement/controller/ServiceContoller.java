package com.main.studentManagement.controller;

import com.main.studentManagement.entity.StudentInfo;
import com.main.studentManagement.entity.User;
import com.main.studentManagement.responseHandler.LoginResponse;
import com.main.studentManagement.service.CustomeuserDetailsService;
import com.main.studentManagement.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ServiceContoller {
    private final StudentServiceImpl service;
    private final CustomeuserDetailsService customeuserDetailsService;
    
    @Autowired
    public ServiceContoller(StudentServiceImpl service,CustomeuserDetailsService customeuserDetailsService){
        this.service = service;
        this.customeuserDetailsService = customeuserDetailsService;
    }
    
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

    @PostMapping("/admin/register")
    public User registerUser(@RequestBody User user){
        return customeuserDetailsService.registerAdmin(user.getUsername(),user.getPassword());
    }

    @GetMapping("/user/username")
    public String getUserByUsername(@PathVariable String username){
        return customeuserDetailsService.loadUserByUsername(username).getUsername();
    }
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody User user){
        return customeuserDetailsService.loginUser(user.getUsername(),user.getPassword());
    }


}
