package com.company.src.main.java.com.example.mentormatching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String displayHomePage(){
        return "home";
    }
}
