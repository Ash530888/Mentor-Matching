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
            new User("abc@qmul.ac.uk","{noop}23", "USER"),
            new User("fatin@qmul.ac.uk","{noop}12","USER")
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

}
