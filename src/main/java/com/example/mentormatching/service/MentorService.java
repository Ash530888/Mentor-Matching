package com.example.mentormatching.service;


import com.example.mentormatching.dao.UserDAO;
import com.example.mentormatching.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorService {

    @Autowired
    UserDAO repo;


    // note does not check being same person yet
    public List<User > getMentor(){

        List<User> allUser = repo.dummyUsers();
        List<User> mentor = new ArrayList<>();

        for( User user : allUser){
            if (user.getRoleStatus().equals("BOTH") || user.getRoleStatus().equals("MENTOR"))
                if(user.getMentor().isVerified() == true) mentor.add(user);
        }

        return mentor;

    }

    public List<User> getMentorByName(String name){

        List<User> returnMatch = new ArrayList<>();

        for( User user : getMentor()){
            if (user.getTestProfile().getName().equals(name)) returnMatch.add(user);
        }
        return returnMatch;

    }

    public User getMentorByEmail(String email){

        for( User user : getMentor()){
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    public List<User> getUnverifiedMentor(){
        List<User> allUser = repo.dummyUsers();
        List<User> unverifiedMentor = new ArrayList<>();
        for( User user : allUser){
            if (user.getRoleStatus().equals("BOTH") || user.getRoleStatus().equals("MENTOR"))
                if(user.getMentor().isVerified() == false) unverifiedMentor.add(user);
        }
        return unverifiedMentor;
    }
    public User getUnverifiedMentorByEmail(String email){

        for( User user : getUnverifiedMentor()){
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }
}
