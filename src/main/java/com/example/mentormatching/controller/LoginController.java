package com.example.mentormatching.controller;


import com.example.mentormatching.model.MenteeProfileFacade;
import com.example.mentormatching.model.MentorProfileFacade;
import com.example.mentormatching.model.User;
import com.example.mentormatching.security.UserDetail;
import com.example.mentormatching.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class LoginController {




    @Autowired
    userService userService;


    @GetMapping("/")
    public String getLandingPage(RedirectAttributes redirectAttributes){ return "redirect:/login";}


    @GetMapping("/login")
    public String getLoginPage(){ return "login";}


    @GetMapping("/signup")
    public String getSigninPage(Model model, Authentication authentication){
        UserDetail userDetail = null;

        if (authentication != null) userDetail = (UserDetail) authentication.getPrincipal();

        if (userDetail != null){
            model.addAttribute("user",userDetail.getUser());
            model.addAttribute("update",true);
        }
        else {
            model.addAttribute("user",new User());
            model.addAttribute("update",false);
        }


        return "signup";
    }


    @PostMapping("/processSignup")
    public String processSignup(@ModelAttribute User user,Authentication authentication, RedirectAttributes redirectAttributes){

        if (authentication != null) {
            UserDetail previousDetail = (UserDetail) authentication.getPrincipal();
            userService.update(previousDetail.getUser(), user);
            return "redirect:/home";

        }
        else{
            System.out.println(user.getUserRole());
            if (user.getUserRole().equals("MENTOR") ) user.setMentorStatus();
            else user.setMenteeStatus();
            System.out.println(user.getTestProfile().getName());
            userService.save(user);
            System.out.println("Home");

            return "redirect:/login";

        }



    }











}
