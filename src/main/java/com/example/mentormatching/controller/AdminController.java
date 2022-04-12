package com.example.mentormatching.controller;


import com.example.mentormatching.service.MenteeService;
import com.example.mentormatching.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    MentorService mentorService;

    @Autowired
    MenteeService menteeService;

    @GetMapping("/suggestMatch")
    public String getSuggestPage(Model model){

        model.addAttribute("Mentor", mentorService.getMentor());
        model.addAttribute("unmatchedMentee", menteeService.getMentee());

        return "suggestMatch";
    }
}
