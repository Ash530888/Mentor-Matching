package com.example.mentormatching.service;


import com.example.mentormatching.dao.UserDAO;
import com.example.mentormatching.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenteeService {


    @Autowired
    UserDAO repo;


    // note does not check being same person yet
    public List<User> getMentor(){

        List<User> allUser = repo.dummyUsers();
        List<User> mentor = new ArrayList<>();

        for( User user : allUser){
            if (user.getRoleStatus() == "BOTH" || user.getRoleStatus() == "MENTOR") mentor.add(user);

        }

        return mentor;

    }
    public List<User> getMentee(){

        List<User> allUser = repo.dummyUsers();
        List<User> mentee = new ArrayList<>();

        for( User user : allUser){
            if (user.getRoleStatus() == "BOTH" || user.getRoleStatus() == "MENTEE"){
                mentee.add(user);
            }
        }

        return mentee;

    }


    public User getMenteeByEmail(String email){
        for( User user : getNonConnectedMentees()){

            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }



    public List<User> getNonConnectedMentees(){
        List<User> mentees = getMentee();
        List<User> menteeNotConnected = new ArrayList<>();

        for (User mentee : mentees){
            if(mentee.getMentee().isConnected() == false) menteeNotConnected.add(mentee);
        }
        return menteeNotConnected;

    }



    public List<User> getMentorByName(String name){

        List<User> returnMatch = new ArrayList<>();

        for( User user : getMentor()){
            System.out.println(user.getTestProfile().getName());
            if (user.getTestProfile().getName().equals(name)) returnMatch.add(user);
        }
        return returnMatch;

    }
}
