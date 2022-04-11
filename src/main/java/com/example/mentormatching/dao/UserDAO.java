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
//        users.add( new User("abc@qmul.ac.uk","{noop}23", "USER", "MENTEE"));
//        users.add( new User("fatin@qmul.ac.uk","{noop}12","USER", "MENTEE"));

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
        found.setPassword(c.getPassword());
        found.setEmail(c.getEmail());
    }

}
