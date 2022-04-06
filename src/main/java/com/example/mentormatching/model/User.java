package com.example.mentormatching.model;

public class User extends Account {



    private String userRole;

    public User(String email, String password, String role, String userRole){
        super(email,password,"",  role);
        this.userRole = userRole;

    }
    public User(){}


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
