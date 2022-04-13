package com.example.mentormatching.dao;

import com.example.mentormatching.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDAO {

    private List<User> users ;
    private List<User> mentor;
    private List<User> mentee;

    public  UserDAO(){
        users = new ArrayList<>();
        mentor = new ArrayList<>();
        mentee = new ArrayList<>();
        users.add( new User("abc@qmul.ac.uk","{noop}23", "MENTOR_MANAGER", null));
//        users.add( new User("fatin@qmul.ac.uk","{noop}12","USER", "MENTEE"));
//        users.add( new User("faatin@qmul.ac.uk","{noop}12","USER", "MENTOR"));


    }

    public  User getUserByEmail(String username){

        for (User a: this.users){
            if (a.getEmail().equals(username)) return a;
        }
        return null;
    }


    public  List<User> dummyUsers(){
        return this.users;
    }



    public void save(User a){

        if (a.getRoleStatus().equals("MENTOR")){ mentor.add(a); }
        else if (a.getRoleStatus().equals("MENTEE"))  mentee.add(a);
        users.add(a);
    }

    public void update(User p, User c){

        User found = getUserByEmail(p.getEmail());

        found.setEmail(c.getEmail());
        found.setPassword(c.getPassword());
        found.getTestProfile().setName(c.getTestProfile().getName());
        found.getTestProfile().setLocation(c.getTestProfile().getLocation());
        found.getTestProfile().setAge(c.getTestProfile().getAge());
        found.getTestProfile().setJobPosition(c.getTestProfile().getJobPosition());
        found.getTestProfile().setGender(c.getTestProfile().getGender());
        found.getTestProfile().setFieldOfWork(c.getTestProfile().getFieldOfWork());
        found.getTestProfile().setDescription(c.getTestProfile().getDescription());
        found.getTestProfile().setLanguages(c.getTestProfile().getLanguages());
        found.getTestProfile().setLanguages(c.getTestProfile().getLanguages());
        found.getTestProfile().setSkills(c.getTestProfile().getSkills());

        if (found.getUserRole().equals("MENTOR")){
            found.getTestMentorProfile().setPreferredMenteeGender(c.getTestMentorProfile().getPreferredMenteeGender());
            found.getTestMentorProfile().setPreferredMenteeAge(c.getTestMentorProfile().getPreferredMenteeAge());
            found.getTestMentorProfile().setPreferredMenteeRole(c.getTestMentorProfile().getPreferredMenteeRole());
            found.getTestMentorProfile().setPreferredMenteeRole(c.getTestMentorProfile().getPreferredMenteeRole());


        }else{
            found.getTestMenteeProfile().setPreferredMentorGender(c.getTestMenteeProfile().getPreferredMentorGender());
            found.getTestMenteeProfile().setPreferredMentorAge(c.getTestMenteeProfile().getPreferredMentorAge());
            found.getTestMenteeProfile().setPreferredMentorPosition(c.getTestMenteeProfile().getPreferredMentorPosition());
            found.getTestMenteeProfile().setPreferredLanguage(c.getTestMenteeProfile().getPreferredLanguage());
            found.getTestMenteeProfile().setCareerGoal(c.getTestMenteeProfile().getCareerGoal());

        }


    }

}
