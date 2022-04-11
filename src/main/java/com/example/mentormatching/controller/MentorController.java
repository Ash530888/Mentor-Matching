package com.example.mentormatching.controller;


import com.example.mentormatching.model.User;
import com.example.mentormatching.security.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MentorController {


    @GetMapping("/view")
    public String test(Model model, Authentication authentication){

        UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        User mentor = userDetail.getUser();


        model.addAttribute("requests",mentor.getMentor().getPendingRequest());

        return "ViewRequests";
    }

}
