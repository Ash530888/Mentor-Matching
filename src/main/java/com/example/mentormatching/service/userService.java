package com.example.mentormatching.service;

import com.example.mentormatching.dao.UserDAO;
import com.example.mentormatching.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userService {

    @Autowired
    private UserDAO repo;


    public void save(User user){
        repo.save(user);
    }

    public List<User> getAllUser(){
        return repo.dummyUsers();
    }


}
