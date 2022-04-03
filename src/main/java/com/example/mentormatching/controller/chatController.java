package com.example.mentormatching.controller;


import com.example.mentormatching.model.MenteeRelationship;
import com.example.mentormatching.model.Mentor;
import com.example.mentormatching.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

// This just for test need to create actual data in dao
@Controller
public class chatController {


    @GetMapping("/chat")
    public String showChat(Model model){

        List<String> names = Arrays.asList("Fatin","Hello");
        model.addAttribute("names",names);

        return "chat";
    }

    @GetMapping("/getChat/{name}")
    public String getChat(@PathVariable("name") String name, Model model){
        Message one = new Message("Fatin","Hello World");
        Message two = new Message("Imon","Hello World TOO");
        MenteeRelationship a = new MenteeRelationship();
        a.addMessage(one);
        a.addMessage(two);

        model.addAttribute("relation",a);



        return "chat";
    }






}
