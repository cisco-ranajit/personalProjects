package com.main.studentManagement.controller;

import com.main.studentManagement.entity.Role;
import com.main.studentManagement.entity.StudentInfo;
import com.main.studentManagement.entity.User;
import com.main.studentManagement.repository.RoleRepository;
import com.main.studentManagement.service.CustomeuserDetailsService;
import com.main.studentManagement.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
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

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ADMIN");
        roles.add(userRole);
        user.setRoles(roles);
        user.setEnabled(true);
        return customeuserDetailsService.createUser(user);
    }

    @GetMapping("/user/username")
    public String getUserByUsername(@PathVariable String username){
        return customeuserDetailsService.loadUserByUsername(username).getUsername();
    }

}
