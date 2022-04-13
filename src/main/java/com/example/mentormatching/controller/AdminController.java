package com.example.mentormatching.controller;


import com.example.mentormatching.service.MenteeService;
import com.example.mentormatching.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

class MenteeSelected{

    public String[] menteeSelected = {"","",""};

    public String[] getMenteeSelected() {
        return menteeSelected;
    }

    public void setMenteeSelected(String[] menteeSelected) {
        this.menteeSelected = menteeSelected;
    }
}

class  MentorSelected{

    public String mentor;

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }
}

@Controller
public class AdminController {

    @Autowired
    MentorService mentorService;

    @Autowired
    MenteeService menteeService;

    @GetMapping("/suggestMatch")
    public String getSuggestPage(Model model){

        String[] menteeSelected = {"","","",""};

        model.addAttribute("mentors", mentorService.getMentor());
        model.addAttribute("unmatchedMentee", menteeService.getNonConnectedMentees());
        model.addAttribute("menteeSelected", new MenteeSelected());
        model.addAttribute("mentorSelected", new MentorSelected());
        return "suggestMentor";
    }

    @PostMapping("/processSuggestMatch")
    public String processSuggestMatch(@ModelAttribute MenteeSelected menteeSelected,@ModelAttribute MentorSelected mentorSelected  ,RedirectAttributes redirectAttributes){
        System.out.println(mentorSelected.mentor);
        for (String a: menteeSelected.menteeSelected){
            System.out.println(a);
        }
        return "home";
    }
}
