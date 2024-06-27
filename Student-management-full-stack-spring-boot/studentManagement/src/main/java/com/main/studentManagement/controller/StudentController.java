package com.main.studentManagement.controller;

import com.main.studentManagement.entity.Role;
import com.main.studentManagement.entity.StudentInfo;
import com.main.studentManagement.entity.User;
import com.main.studentManagement.repository.RoleRepository;
import com.main.studentManagement.service.CustomeuserDetailsService;
import com.main.studentManagement.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    private StudentServiceImpl service;
    @Autowired
    private CustomeuserDetailsService customeuserDetailsService;

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

}
