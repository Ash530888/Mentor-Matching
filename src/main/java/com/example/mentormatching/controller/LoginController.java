package com.example.mentormatching.controller;


import com.example.mentormatching.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    private userService userService = new userService();

    @GetMapping("/login")
    public String getLoginPage(){ return "login";}





}
