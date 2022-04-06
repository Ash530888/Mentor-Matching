package com.example.mentormatching.controller;


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

@Controller
public class LoginController {

    @Autowired
    userService userService;




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
    public String processSignup(@ModelAttribute User user, Authentication authentication){

        if (authentication != null) {
            UserDetail previousDetail = (UserDetail) authentication.getPrincipal();
            userService.update(previousDetail.getUser(), user);
        }
        else{
            userService.save(user);

        }


        return "test";

    }











}
