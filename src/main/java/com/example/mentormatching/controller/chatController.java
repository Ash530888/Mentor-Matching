package com.example.mentormatching.controller;


import com.example.mentormatching.model.User;
import com.example.mentormatching.security.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// This just for test need to create actual data in dao
@Controller
public class chatController {


    private String currentUrl= "";

    @GetMapping("/chat")
    public String showChat(Model model,  Authentication authentication, String name){

        UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        User user = userDetail.getUser();

        if (user.getUserRole().equals("MENTOR")){
            model.addAttribute("mentor", user.getMentor());
            if (name != null){
                model.addAttribute("Message",user.getMentor().getByName(name));
            }
        }else{
            model.addAttribute("mentee",user.getMentee());

            if (name != null){
                model.addAttribute("Message",user.getMentee().getCurrentMentor());
            }
        }


        return "chat";
    }

    @GetMapping("/getChat/{name}")
    public String getChat(@PathVariable("name") String name, Model model, Authentication authentication){

        System.out.println(name);
        showChat(model, authentication, name);
        return "chat";
    }








}
