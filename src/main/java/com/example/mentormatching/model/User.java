package com.example.mentormatching.model;

public class User extends Account {

    public User(String email, String password, String role){
        super(email,password,"",  role);

    }
}
