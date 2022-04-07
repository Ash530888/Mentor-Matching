package com.example.mentormatching.dao;

import com.example.mentormatching.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDAO {

    private List<User> users = Arrays.asList(
            new User("abc@qmul.ac.uk","{noop}23", "USER", "MENTOR"),
            new User("fatin@qmul.ac.uk","{noop}12","USER", "MENTEE")
    );



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
        users.add(a);
    }

    public void update(User p, User c){
        System.out.println(p.getEmail());
        System.out.println(p.getPassword());
        System.out.println(c.getEmail());
        System.out.println(c.getPassword());
        User found = getUserByEmail(p.getEmail());
        found.setPassword(c.getPassword());
        found.setEmail(c.getEmail());
    }

}
