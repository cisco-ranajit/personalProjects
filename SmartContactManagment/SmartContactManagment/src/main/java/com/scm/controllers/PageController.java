package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title", "Spring Boot Application");
        return "home";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/service")
    public String service(){
        return "services";
    }
    
}
