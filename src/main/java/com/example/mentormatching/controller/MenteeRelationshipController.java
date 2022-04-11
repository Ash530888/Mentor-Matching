package com.example.mentormatching.controller;


import com.example.mentormatching.model.MenteeRelationship;
import com.example.mentormatching.model.User;
import com.example.mentormatching.security.UserDetail;
import com.example.mentormatching.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MenteeRelationshipController {

    @Autowired
    MentorService mentorService;


    @GetMapping("/request")
    public String createMenteeRelationship(@RequestParam(value = "requestEmail") String mentorEmail, Authentication authentication){
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        User mentee = userDetail.getUser();
        User mentor = mentorService.getMentorByEmail(mentorEmail);

        MenteeRelationship currentRelation = mentee.getMentee().getCurrentMentor();

        mentee.getMentee().getCurrentMentor().requestMentee(mentee.getMentee());
        mentor.getMentor().addPendingRequest(currentRelation);


        return "home";
    }

    @GetMapping("/requestDecline")
    public String handleRejectRequest(@RequestParam(value = "requestEmail") String menteeEmail, Authentication authentication, RedirectAttributes redirectAttributes){
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        User mentor = userDetail.getUser();
        mentor.getMentor().removeMenteeFromPending(menteeEmail);

        return "redirect:/view";
    }

    @GetMapping("/requestAccept")
    public String handleAcceptRequest(@RequestParam(value = "requestEmail") String menteeEmail, Authentication authentication, RedirectAttributes redirectAttributes){
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        User mentor = userDetail.getUser();
        MenteeRelationship acceptedRelation = mentor.getMentor().removeMenteeFromPending(menteeEmail);
        acceptedRelation.setMentor(mentor.getMentor());
        mentor.getMentor().addConnectedMentees(acceptedRelation);


        return "redirect:/view";
    }
}
