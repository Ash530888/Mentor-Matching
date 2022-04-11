package com.example.mentormatching.controller;


import com.example.mentormatching.model.User;
import com.example.mentormatching.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MenteeController {

    @Autowired
    MentorService mentorService;



    @GetMapping("/send")
    public String getSend(Model model, RedirectAttributes redirectAttributes){

        return "sendRequest";
    }


    @GetMapping("/getMentor")
    public String getSearchMentor(@RequestParam("name") String name, Model model){
        List<User> mentors = mentorService.getMentorByName(name);

        if (mentors.size() == 0) model.addAttribute("notFound","Not Found");
        model.addAttribute("mentors",mentors);

        return "sendRequest";
    }
}
