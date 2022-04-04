package com.example.mentormatching.controller;

import com.example.mentormatching.model.User;
import com.example.mentormatching.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// just for test
@Controller
public class testing {

    @Autowired
    userService userService;

    @GetMapping("/")
    public String test(){




        return "test";
    }


    @GetMapping("/check")
    public String test1(){
        System.out.println(userService.getAllUser().size());
        for (User check: userService.getAllUser()){
            System.out.println(check.getEmail());
        }
        return "test";
    }
}
