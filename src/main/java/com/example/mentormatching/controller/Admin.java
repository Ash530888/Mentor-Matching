package com.example.mentormatching.controller;


import com.example.mentormatching.service.MenteeService;
import com.example.mentormatching.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin {

    @Autowired
    MentorService mentorService;

    @Autowired
    MenteeService menteeService;

    @GetMapping("/suggestMatch")
    public String getSuggestPage(){
        System.out.println(menteeService.getNonConnectedMentees().size());
        System.out.println(mentorService.getMentor().size());
        return "home";
    }
}
