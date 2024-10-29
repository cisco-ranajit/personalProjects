package com.medibill.main.controller;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.medibill.main.exceptionhandler.LoggedRuntimeException;

@Controller
public class ApiServerModule {
    
    @GetMapping("/login")
    public String getLoginPage(){
        throw new LoggedRuntimeException("Login page not found");
    }

    @GetMapping("/home")
    public String getHomePage(){
        throw new LoggedRuntimeException("home page not found");
    }

}
