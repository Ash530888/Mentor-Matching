package com.example.mentormatching.controller;


import com.example.mentormatching.model.User;
import com.example.mentormatching.security.UserDetail;
import com.example.mentormatching.service.MentorService;
import com.example.mentormatching.service.MentorSuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

    @Autowired
    MentorSuggestService mentorSuggestService;





    @GetMapping("/send")
    public String getSend(Model model, RedirectAttributes redirectAttributes,Authentication authentication){
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        User loggedInMentee = userDetail.getUser();

        List<User> mentors = mentorSuggestService.sortMentors(mentorService.getMentor(),loggedInMentee);


        for(int x =0; x<3 && x<mentors.size() ; x++)loggedInMentee.getMentee().addSuggestedMentor(mentors.get(x).getMentor());

        System.out.println(loggedInMentee.getMentee().getSuggestedMentor().size());

        model.addAttribute("suggestedMentor",loggedInMentee.getMentee().getSuggestedMentor());

        return "sendRequest";
    }


    @GetMapping("/getMentor")
    public String getSearchMentor(@RequestParam("name") String name, Model model, Authentication authentication){
        List<User> mentors = mentorService.getMentorByName(name);

        if (mentors.size() == 0) model.addAttribute("notFound","Not Found");
        model.addAttribute("mentors",mentors);

        return "sendRequest";
    }


}
